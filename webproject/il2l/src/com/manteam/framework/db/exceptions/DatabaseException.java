package com.manteam.framework.db.exceptions;

public class DatabaseException extends Exception {
	public static final String DATABASE_UNAVAILABLE = "DATABASE_UNAVAILABLE";
	public static final String DATABASE_DRIVER_UNAVAILABLE = "DATABASE_DRIVER_UNAVAILABLE";
	public static final String SQL_EXCEPTION = "SQL_EXCEPTION";
	public static final String DATABASE_CONFIG_EXCEPTION = "Invalid Configuration File or details";
	public DatabaseException() {
		super();
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseException(Throwable cause) {
		super(cause);
	}
}
