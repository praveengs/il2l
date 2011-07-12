/**
 * 
 */
package com.manteam.iwant2learn.subject.exceptions;

/**
 * @author Praveen
 * 
 */
public class MaintainSubjectsException extends Exception {

	public static final String INVALID_MODULE_ID = "Invalid Module Id Generated";	
	public static final String SUBMODULE_ALREADY_PRESENT = "The submodule is already present for the subject";

	public MaintainSubjectsException() {
		super();
	}

	public MaintainSubjectsException(String message) {
		super(message);
	}

	public MaintainSubjectsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintainSubjectsException(Throwable cause) {
		super(cause);
	}

}
