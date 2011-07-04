package com.manteam.iwant2learn.questions.sql;

public class MaintainQuestionQueries {

	public static final String INSERT_QUESTION = "INSERT INTO EXAM_QUESTIONS (SUBMODULE_ID, QUESTION, QUES_IMG, "
			+ "QNO_YEAR_MARKS, ANSWER,ANSWER_IMG) "
			+ "VALUES (?,?,?,?,?,?)";

	public static final String GET_SUBMODULE_ID = "SELECT A.SYB_SUB_SUBMODULE_ID "
			+ " FROM SYB_SUBMODULE A, SYB_MODULE B, SYB_SUBJECT C "
			+ " WHERE C.SUBJECT_NAME = ? AND B.MODULE_NAME = ? AND A.SUBMODULE_NAME = ? "
			+ " AND A.MODULE_REF = B.SYB_SUB_MODULE_ID AND B.MODULE_SUBJECT_REF = C.IDSYB_SUBJECT";

}
