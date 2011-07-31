/**
 * 
 */
package com.manteam.iwant2learn.keywords.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

/**
 * @author Praveen
 * 
 */
public class KeyWordMaintainSql extends AbstractSql {

	public int getKeyWordId(Connection connection, String subjectName,
			String submoduleName, String keywordName) throws SQLException {
		int keyWordId = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = KeyWordMaintenanceQueryConstructor
					.getKeyWordId(connection, subjectName, submoduleName,
							keywordName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				keyWordId = resultSet
						.getInt(KeyWordQueryConstants.SYB_KEYWORD_ID);
			}
		} finally {
			close(resultSet, preparedStatement);
		}

		return keyWordId;
	}

	public int saveKeyWord(Connection connection,
			LogonAttributesVO logonAttributesVO, KeyWordSaveVO keyWordSaveVO,
			int submoduleId, Date modifiedDate) throws SQLException {
		int keyWordId = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int rowsInserted = 0;
		try {
			preparedStatement = KeyWordMaintenanceQueryConstructor.saveKeyWord(
					connection, logonAttributesVO, keyWordSaveVO, modifiedDate);
			rowsInserted = preparedStatement.executeUpdate();
			// preparedStatement.close();

			System.out.println("Rows Inserted" + rowsInserted);
			if (rowsInserted > 0) {
				preparedStatement = KeyWordMaintenanceQueryConstructor
						.getLastInsertedId(connection);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					keyWordId = (int) resultSet
							.getLong(KeyWordQueryConstants.LAST_INSERTED_ID);
				}
				// int lastQuestionId = resultSet.getInt(1);
				System.out.println("Last Keyword Id Inserted: " + keyWordId);
				// preparedStatement.close();
				// resultSet.close();

				preparedStatement = KeyWordMaintenanceQueryConstructor
						.saveKeyWordSubmoduleMap(connection, keyWordId,
								submoduleId);
				preparedStatement.executeUpdate();
			}

		} finally {
			close(resultSet, preparedStatement);
		}
		return keyWordId;
	}

	/**
	 * Method to retrieve the keyword info
	 * 
	 * @param connection
	 * @param keyWordId
	 * @return
	 * @throws SQLException
	 */
	public KeyWordVO retrieveKeywordInfo(Connection connection, int keyWordId)
			throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		KeyWordVO keyWordVO = null;
		try {
			preparedStatement = KeyWordMaintenanceQueryConstructor
					.retrieveKeywordInfo(connection, keyWordId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				keyWordVO = new KeyWordVO();
				keyWordVO.setKeyWordId(resultSet
						.getInt(KeyWordQueryConstants.SYB_KEYWORD_ID));
				keyWordVO.setKeywordName(resultSet
						.getString(KeyWordQueryConstants.KEYWORD));
				keyWordVO.setQuantities(resultSet
						.getString(KeyWordQueryConstants.QUANTITIES));
				keyWordVO.setSymbols(resultSet
						.getString(KeyWordQueryConstants.SYMBOLS));
				keyWordVO.setUnits(resultSet
						.getString(KeyWordQueryConstants.UNITS));
				keyWordVO.setFormulae(resultSet
						.getString(KeyWordQueryConstants.FORMULAE));
				keyWordVO.setData(resultSet
						.getString(KeyWordQueryConstants.DATA));
				keyWordVO.setKeyWordImageByteArray(resultSet
						.getBytes(KeyWordQueryConstants.KEYWORD_IMAGE));
				keyWordVO.setKeyWordDescription(resultSet
						.getString(KeyWordQueryConstants.KEYWORD_DESC));
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return keyWordVO;
	}

	/**
	 * Method to retrieve the image info for the keyword
	 * 
	 * @param connection
	 * @param keyWordId
	 * @return
	 * @throws SQLException
	 */
	public ImageStreamVO retrieveImageInfo(Connection connection, int keyWordId)
			throws SQLException {
		ImageStreamVO imageStreamVO = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = KeyWordMaintenanceQueryConstructor
					.retrieveImageInfo(connection, keyWordId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				imageStreamVO = new ImageStreamVO();
				imageStreamVO.setImageByteArray(resultSet
						.getBytes(KeyWordQueryConstants.KEYWORD_IMAGE));
				imageStreamVO.setImageString(resultSet
						.getString(KeyWordQueryConstants.KEYWORD_IMAGE));
			}

		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return imageStreamVO;
	}

}
