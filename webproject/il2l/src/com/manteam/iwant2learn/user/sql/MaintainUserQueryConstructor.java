/**
 * 
 */
package com.manteam.iwant2learn.user.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.manteam.iwant2learn.questions.sql.MaintainQuestionQueries;
import com.manteam.iwant2learn.user.vo.LoginVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.user.vo.UserSaveVO;

/**
 * @author Praveen
 * 
 */
public class MaintainUserQueryConstructor {

	/**
	 * Method to retrieve the user details
	 * 
	 * @param connection
	 * @param loginVO
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement retrieveUserDetails(Connection connection,
			LoginVO loginVO) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainUserQueries.RETRIEVE_USER_DETAILS);
		preparedStatement.setString(1, loginVO.getUserName());
		preparedStatement.setString(2, loginVO.getUserPassword());
		return preparedStatement;
	}

	/**
	 * Method to retrieve the user id for a given user name
	 * 
	 * @param connection
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement retrieveUserIdForUserName(
			Connection connection, String userName) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainUserQueries.RETRIEVE_USER_ID);
		preparedStatement.setString(1, userName);
		return preparedStatement;
	}

	/**
	 * This method is used to create the statement for saving a user into
	 * the system
	 * 
	 * @param connection
	 * @param logonAttributesVO
	 * @param userSaveVO
	 * @param modifiedDate
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement saveUserDetails(Connection connection,
			LogonAttributesVO logonAttributesVO, UserSaveVO userSaveVO,
			Date modifiedDate) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainUserQueries.INSERT_USER_DETAILS);
		preparedStatement.setString(1, userSaveVO.getUserName());
		preparedStatement.setString(2, userSaveVO.getPassword());
		preparedStatement.setString(3, userSaveVO.getUserRole());
		preparedStatement.setString(4, userSaveVO.getEmailId());
		preparedStatement.setString(5, userSaveVO.getPhoneNumber());
		preparedStatement.setString(6, userSaveVO.getAddressField1());
		preparedStatement.setString(7, userSaveVO.getAddressField2());
		preparedStatement.setString(8, logonAttributesVO.getUserName());
		preparedStatement.setString(9, logonAttributesVO.getUserRole());
		preparedStatement.setTimestamp(10,
				new Timestamp(modifiedDate.getTime()));

		return preparedStatement;
	}
	
	/**
	 * Method to retrieve the last inserted user id
	 * 
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement getLastInsertedId(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainUserQueries.GET_LAST_INSERTED_ID);
		return preparedStatement;
	}
}
