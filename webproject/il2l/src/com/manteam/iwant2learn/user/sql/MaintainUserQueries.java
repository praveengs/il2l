/**
 * 
 */
package com.manteam.iwant2learn.user.sql;

/**
 * @author Praveen
 * 
 */
public class MaintainUserQueries {

	public static final String RETRIEVE_USER_DETAILS = "SELECT USER_NAME, USER_ROLE FROM"
			+ " user_details " + " WHERE USER_NAME = ? and USER_PASSWORD = ?";
	public static final String RETRIEVE_USER_ID = "SELECT USER_ID FROM"
			+ " user_details WHERE USER_NAME = ? ";
	public static final String INSERT_USER_DETAILS = "INSERT INTO user_details "
			+ "(USER_NAME, USER_PASSWORD, USER_ROLE, EMAIL_ID, PHONE_NUMBER, ADDRESS_LINE_1, ADDRESS_LINE_2, "
			+ "LAST_MODIFIED_BY, LAST_MODIFIED_ROLE, LAST_MODIFIED_DATE)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_LAST_INSERTED_ID = " SELECT LAST_INSERT_ID() ";

}
