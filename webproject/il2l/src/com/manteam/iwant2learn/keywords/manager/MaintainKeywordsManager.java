/**
 * 
 */
package com.manteam.iwant2learn.keywords.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.interfaces.CommonInterfaceConstants;
import com.manteam.iwant2learn.keywords.exceptions.MaintainKeyWordsException;
import com.manteam.iwant2learn.keywords.sql.KeyWordMaintainSql;
import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionSql;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;
import com.manteam.iwant2learn.subject.server.MaintainSubjectsManager;
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

/**
 * @author Praveen
 * 
 */
public class MaintainKeywordsManager extends AbstractManager {

	public int saveKeyword(LogonAttributesVO logonAttributesVO,
			KeyWordSaveVO keyWordSaveVO) throws MaintainKeyWordsException,
			SystemException {
		// boolean isKeyWordAdded = false;
		int keywordId = 0;
		int submoduleId = 0;
		Connection connection = null;
		KeyWordMaintainSql keyWordMaintainSql = new KeyWordMaintainSql();
		try {
			connection = getConnection();
			keywordId = keyWordMaintainSql.getKeyWordId(connection,
					keyWordSaveVO.getSubjectName(),
					keyWordSaveVO.getSubmoduleName(),
					keyWordSaveVO.getKeywordName());
			if (keywordId > 0) {
				throw new MaintainKeyWordsException(
						MaintainKeyWordsException.KEYWORD_ALREADY_EXISTS
								+ "with keyword id" + keywordId);
			}
			MaintainSubjectsManager maintainSubjectsManager = new MaintainSubjectsManager();
			if (WEB_APP_MODE.equals(getMode())) {
				maintainSubjectsManager.setMode(WEB_APP_MODE);
			} else {
				maintainSubjectsManager.setMode(CLIENT_APP_MODE);
			}
			submoduleId = maintainSubjectsManager.getSubmoduleForSubject(
					keyWordSaveVO.getSubjectName(),
					keyWordSaveVO.getSubmoduleName());

			connection.setAutoCommit(false);
			if (logonAttributesVO == null) {
				logonAttributesVO = getLogonAttributesVO();
			}
			keywordId = keyWordMaintainSql.saveKeyWord(connection,
					logonAttributesVO, keyWordSaveVO, submoduleId, new Date());
			connection.commit();

		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return keywordId;
	}

	/**
	 * Method to retrieve the keyword information
	 * 
	 * @param keyWordId
	 * @return
	 * @throws SystemException
	 */
	public KeyWordVO retrieveKeywordInfo(int keyWordId) throws SystemException {
		KeyWordMaintainSql keyWordMaintainSql = new KeyWordMaintainSql();

		try {
			return keyWordMaintainSql.retrieveKeywordInfo(getConnection(),
					keyWordId);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {

			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}

	}

	/**
	 * Method to retrieve the keyword image
	 * 
	 * @param keyWordId
	 * @return
	 * @throws SystemException
	 */
	public ImageStreamVO retrieveImageInfo(int keyWordId)
			throws SystemException {
		ImageStreamVO imageStreamVO = null;
		try {

			KeyWordMaintainSql keyWordMaintainSql = new KeyWordMaintainSql();
			imageStreamVO = keyWordMaintainSql.retrieveImageInfo(
					getConnection(), keyWordId);

		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return imageStreamVO;
	}

}
