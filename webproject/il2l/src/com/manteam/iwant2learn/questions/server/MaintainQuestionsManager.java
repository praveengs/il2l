/**
 * 
 */
package com.manteam.iwant2learn.questions.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.interfaces.CommonInterfaceConstants;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionSql;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionsManager extends AbstractManager {

	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {

		boolean isInserted = false;
		try {

			Connection conn = getConnection();
			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();
			int submoduleId = maintainQuestionSql.getSubmoduleId(conn,
					examQuestionsVO);
			if (submoduleId == -1) {
				throw new MaintainQuestionsException(
						MaintainQuestionsException.INVALID_SUBJ_MOD_SUBMOD_COMB);
			}
			int recordsUpdated = maintainQuestionSql.saveQuestion(conn,
					examQuestionsVO, submoduleId);
			if (recordsUpdated > 0) {
				isInserted = true;
			}
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return isInserted;
	}

	public boolean saveQuestionForSubmodules(
			LogonAttributesVO logonAttributesVO, QuestionSaveVO questionSaveVO)
			throws SystemException, MaintainQuestionsException {

		Connection conn = null;
		boolean isInserted = false;
		try {
			conn = getConnection();

			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();
			Collection<String> submodules = new ArrayList<String>(1);
			submodules.add(questionSaveVO.getSubmodule());

			HashMap<Integer, String> submoduleIdMap = maintainQuestionSql
					.getSubmoduleIds(conn, questionSaveVO.getSubjectName(),
							submodules);

			/*
			 * int submoduleId = maintainQuestionSql .getSubmoduleId(conn,
			 * questionSaveVO.getSubjectName(), questionSaveVO.getSubmodule());
			 */

			if (submoduleIdMap == null
					|| submoduleIdMap.keySet().size() != submodules.size()) {
				throw new MaintainQuestionsException(
						MaintainQuestionsException.INVALID_SUBJ_SUBMOD_COMB);
			}
			/*
			 * if (submoduleId == 0) { throw new MaintainQuestionsException(
			 * MaintainQuestionsException.INVALID_SUBJ_SUBMOD_COMB); }
			 */
			HashMap<Integer, String> keyWordIdMap = null;
			if (questionSaveVO.getKeywords() != null
					&& questionSaveVO.getKeywords().size() > 0) {
				keyWordIdMap = maintainQuestionSql.getKeyWordIds(conn,
						submoduleIdMap.keySet(), questionSaveVO.getKeywords());

				if (keyWordIdMap == null
						|| keyWordIdMap.keySet().size() != questionSaveVO
								.getKeywords().size()) {
					throw new MaintainQuestionsException(
							MaintainQuestionsException.INVALID_KEYWORD_EXISTS);
				}
			}
			conn.setAutoCommit(false);
			int recordsUpdated = maintainQuestionSql.saveQuestion(conn,
					questionSaveVO, submoduleIdMap.keySet(),
					((keyWordIdMap == null) ? null : keyWordIdMap.keySet()),
					logonAttributesVO, new Date());
			/*
			 * int recordsUpdated = maintainQuestionSql.saveQuestion(conn,
			 * questionSaveVO, submoduleId, logonAttributesVO, new Date());
			 */
			if (recordsUpdated > 0) {
				isInserted = true;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return isInserted;
	}

	/**
	 * Method to retrieve the image info for the question
	 * 
	 * @param searchConstant
	 * @param questionId
	 * @return
	 * @throws SystemException
	 */
	public ImageStreamVO retrieveImageInfoForQuestion(String searchConstant,
			int questionId) throws SystemException {

		ImageStreamVO imageStreamVO = null;
		try {

			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();

			if (CommonInterfaceConstants.QUESTION_IMG.equals(searchConstant)) {
				imageStreamVO = maintainQuestionSql
						.retrieveImageInfoForQuestion(getConnection(),
								questionId);
			} else if (CommonInterfaceConstants.ANSWER_IMG
					.equals(searchConstant)) {
				imageStreamVO = maintainQuestionSql
						.retrieveImageInfoForQuestionAnswer(getConnection(),
								questionId);
			}

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
