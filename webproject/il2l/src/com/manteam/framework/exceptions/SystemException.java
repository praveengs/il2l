package com.manteam.framework.exceptions;

public class SystemException extends Exception {
	public static final String UNEXPECTED_DB_ERROR = "UNEXPECTED_DB_ERROR";
	public static final String CONNECTION_UNAVAILABLE = "CONNECTION_UNAVAILABLE";
	
	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}
}
