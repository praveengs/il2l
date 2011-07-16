/**
 * 
 */
package com.manteam.iwant2learn.user.exceptions;

/**
 * @author Praveen
 * 
 */
public class MaintainUserException extends Exception {

	public static final String USER_DOES_NOT_EXIST = "The user with the credentials provided does not exist in the system";
	public static final String USERNAME_ALREADY_EXISTS = "The user name  is already taken";

	public MaintainUserException() {
		super();
	}

	public MaintainUserException(String message) {
		super(message);
	}

	public MaintainUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintainUserException(Throwable cause) {
		super(cause);
	}
}
