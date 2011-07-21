/**
 * 
 */
package com.manteam.iwant2learn.user.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.user.vo.LoginVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.user.vo.UserSaveVO;

/**
 * @author Praveen
 * 
 */
public class MaintainUserSql extends AbstractSql {

	/**
	 * Method to get the user details from the system
	 * 
	 * @param connection
	 * @param loginVO
	 * @return
	 * @throws SQLException
	 */
	public LogonAttributesVO retrieveUserDetails(Connection connection,
			LoginVO loginVO) throws SQLException {
		LogonAttributesVO logonAttributesVO = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = MaintainUserQueryConstructor
					.retrieveUserDetails(connection, loginVO);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				logonAttributesVO = new LogonAttributesVO();
				logonAttributesVO.setUserName(resultSet
						.getString(MaintainUserQueryConstants.USER_NAME));
				logonAttributesVO.setUserRole(resultSet
						.getString(MaintainUserQueryConstants.USER_ROLE));
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return logonAttributesVO;
	}

	/**
	 * THis method retrieves the user id for the specified user name. If the
	 * user does not exist, the user id is set as 0 and returned
	 * 
	 * @param connection
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public int retrieveUserIdForUserName(Connection connection, String userName)
			throws SQLException {
		int userId = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = MaintainUserQueryConstructor
					.retrieveUserIdForUserName(connection, userName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userId = resultSet.getInt(MaintainUserQueryConstants.USER_ID);
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return userId;
	}

	public int addUser(Connection connection,
			LogonAttributesVO logonAttributesVO, UserSaveVO userSaveVO,
			Date modifiedDate) throws SQLException {
		int userId = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = MaintainUserQueryConstructor.saveUserDetails(
					connection, logonAttributesVO, userSaveVO, modifiedDate);
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				preparedStatement = MaintainUserQueryConstructor
						.getLastInsertedId(connection);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					userId = (int) resultSet
							.getLong(MaintainUserQueryConstants.LAST_INSERTED_ID);
				}
			}
		} finally {
			close(resultSet, preparedStatement);
		}
		return userId;
	}

}
