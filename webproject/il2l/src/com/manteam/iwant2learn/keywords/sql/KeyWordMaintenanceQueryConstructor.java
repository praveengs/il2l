package com.manteam.iwant2learn.keywords.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

public class KeyWordMaintenanceQueryConstructor {

	public static PreparedStatement getKeyWordId(Connection connection,
			String subjectName, String submoduleName, String keywordName)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(KeyWordMaintenanceQueries.GET_KEYWORD_ID);
		preparedStatement.setString(1, keywordName);
		preparedStatement.setString(2, submoduleName);
		preparedStatement.setString(3, subjectName);
		return preparedStatement;
	}

	public static PreparedStatement getLastInsertedId(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(KeyWordMaintenanceQueries.GET_LAST_INSERTED_ID);
		return preparedStatement;
	}

	public static PreparedStatement saveKeyWordSubmoduleMap(
			Connection connection, int keyWordId, int submoduleId) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(KeyWordMaintenanceQueries.INSERT_KEYWORD_SUBMODULE_MAP);
		preparedStatement.setInt(1, keyWordId);
		preparedStatement.setInt(2, submoduleId);
		return preparedStatement;
	}

	public static PreparedStatement saveKeyWord(Connection connection,
			LogonAttributesVO logonAttributesVO, KeyWordSaveVO keyWordSaveVO,
			Date modifiedDate) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(KeyWordMaintenanceQueries.INSERT_KEYWORD);
		preparedStatement.setString(1, keyWordSaveVO.getKeywordName());
		preparedStatement.setString(2, keyWordSaveVO.getKeyWordDescription());
		if (keyWordSaveVO.getKeywordImageStream() != null) {
			preparedStatement.setBinaryStream(3,
					keyWordSaveVO.getKeywordImageStream(), keyWordSaveVO.getKeyWordImageLength());
		} else {
			preparedStatement.setBinaryStream(3, null, 0);
		}
		preparedStatement.setString(4, logonAttributesVO.getUserName());
		preparedStatement.setString(5, logonAttributesVO.getUserRole());
		preparedStatement
				.setTimestamp(6, new Timestamp(modifiedDate.getTime()));
		return preparedStatement;
	}

}
