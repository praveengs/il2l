package com.manteam.iwant2learn.questions.exceptions;

public class MaintainQuestionsException extends Exception {
	public static final String INVALID_SUBJ_MOD_SUBMOD_COMB = "There is no valid combination for the given Subject, Module, Submodule combination";
	
	
	public MaintainQuestionsException() {
		super();
	}

	public MaintainQuestionsException(String message) {
		super(message);
	}

	public MaintainQuestionsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintainQuestionsException(Throwable cause) {
		super(cause);
	}
}
