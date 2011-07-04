/**
 * 
 */
package com.manteam.framework.util;

/**
 * @author Praveen
 *
 */
public class XMLReadException extends Exception{
	
	public static final String SAX_EXCEPTION = "saxException";
	public static final String IO_EXCEPTION = "Unable to read the File";
	public static final String PARSER_EXCEPTION = "Parser Configuration Exception";
	public XMLReadException() {
		super();
	}

	public XMLReadException(String message) {
		super(message);
	}

	public XMLReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public XMLReadException(Throwable cause) {
		super(cause);
	}
}
