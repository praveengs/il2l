/**
 * 
 */
package com.manteam.iwant2learn.keywords.exceptions;

/**
 * @author Praveen
 *
 */
public class MaintainKeyWordsException extends Exception {
	public static final String KEYWORD_ALREADY_EXISTS = "The keyword is already present in the System for the Subject, Module, Submodule Combination";
	
	
	
	public MaintainKeyWordsException() {
		super();
	}

	public MaintainKeyWordsException(String message) {
		super(message);
	}

	public MaintainKeyWordsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintainKeyWordsException(Throwable cause) {
		super(cause);
	}
}
