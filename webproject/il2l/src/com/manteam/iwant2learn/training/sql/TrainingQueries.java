package com.manteam.iwant2learn.training.sql;

public abstract class TrainingQueries {

	public static final String RETRIEVE_SUBJECT_DETAILS = "SELECT A.IDSYB_SUBJECT, A.SUBJECT_NAME, B.SYB_SUB_MODULE_ID, B.MODULE_NAME, C.SYB_SUB_SUBMODULE_ID, C.SUBMODULE_NAME "
			+ "FROM syb_subject A, syb_module B, syb_submodule C "
			+ "WHERE A.SUBJECT_NAME = ? "
			+ "AND B.MODULE_SUBJECT_REF = A.IDSYB_SUBJECT "
			+ "AND C.MODULE_REF = B.SYB_SUB_MODULE_ID ";

	public static final String RETRIEVE_QUESTIONS_SUBMOD = "SELECT D.SUBJECT_NAME, C.MODULE_NAME, B.SUBMODULE_NAME, B.SUBMODULE_DESC, A.QUESTION, A.QUES_IMG_NAME, A.QUES_IMG, A.QNO_YEAR_MARKS, "
			+ "A.ANSWER, A.ANSWER_IMG_NAME, A.ANSWER_IMG "
			+ "FROM exam_questions A, syb_submodule B, syb_module C, syb_subject D, exam_ques_submodule_map E "
			+ "WHERE  A.EXAM_QUESTIONS_ID = E.QUESTION_ID AND E.SUBMODULE_ID = B.SYB_SUB_SUBMODULE_ID "
			+ "AND B.SUBMODULE_NAME IN ";

	public static final String RETRIEVE_QUESTIONS_REST = " AND B.MODULE_REF = C.SYB_SUB_MODULE_ID "
			+ "AND C.MODULE_SUBJECT_REF = D.IDSYB_SUBJECT "
			+ "AND D.SUBJECT_NAME = ?";

	public static final String GET_KEYWORD_FOR_SUBMODULES = "SELECT C.SUBMODULE_NAME, A.KEYWORD, A.QUANTITIES, A.SYMBOLS, A.UNITS, A.FORMULAE, A.DATA "
			+ " FROM syb_keyword A, sub_keyword_submodule_map B, syb_submodule C, syb_module D, syb_subject E"
			+ " WHERE C.SYB_SUB_SUBMODULE_ID = B.SUBMODULE_ID"
			+ " AND A.SYB_KEYWORD_ID = B.KEYWORD_ID"
			+ " AND C.SUBMODULE_NAME IN ";

	public static final String GET_KEYWORD_FOR_SUBMODULES_REST = " AND C.MODULE_REF = D.SYB_SUB_MODULE_ID "
			+ " AND D.MODULE_SUBJECT_REF = E.IDSYB_SUBJECT"
			+ " AND E.SUBJECT_NAME = ?";

}
