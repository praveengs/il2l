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
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.training.sql.TrainingQueryConstants;
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
						.getInt(TrainingQueryConstants.SYB_KEYWORD_ID));
				keyWordVO.setKeywordName(resultSet
						.getString(TrainingQueryConstants.KEYWORD));
				keyWordVO.setQuantities(resultSet
						.getString(TrainingQueryConstants.QUANTITIES));
				keyWordVO.setSymbols(resultSet
						.getString(TrainingQueryConstants.SYMBOLS));
				keyWordVO.setUnits(resultSet
						.getString(TrainingQueryConstants.UNITS));
				keyWordVO.setFormulae(resultSet
						.getString(TrainingQueryConstants.FORMULAE));
				keyWordVO.setData(resultSet
						.getString(TrainingQueryConstants.DATA));
				keyWordVO.setKeyWordImageByteArray(resultSet
						.getBytes(TrainingQueryConstants.KEYWORD_IMAGE));
				keyWordVO.setKeyWordDescription(resultSet
						.getString(TrainingQueryConstants.KEYWORD_DESC));
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return keyWordVO;
	}

}
