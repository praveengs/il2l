package com.manteam.iwant2learn.questions.sql;

public class MaintainQuestionQueries {

	public static final String INSERT_QUESTION = "INSERT INTO exam_questions (QUESTION, QUES_IMG, "
			+ "QNO_YEAR_MARKS, ANSWER,ANSWER_IMG, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, LAST_MODIFIED_ROLE) "
			+ "VALUES (?,?,?,?,?,?,?,?)";

	public static final String GET_SUBMODULE_ID = "SELECT A.SYB_SUB_SUBMODULE_ID "
			+ " FROM syb_submodule A, syb_module B, syb_subject C "
			+ " WHERE C.SUBJECT_NAME = ? AND B.MODULE_NAME = ? AND A.SUBMODULE_NAME = ? "
			+ " AND A.MODULE_REF = B.SYB_SUB_MODULE_ID AND B.MODULE_SUBJECT_REF = C.IDSYB_SUBJECT";
	
	public static final String GET_SUBMODULE_IDS_FIRST = "SELECT A.SUBMODULE_NAME, A.SYB_SUB_SUBMODULE_ID "
			+ " FROM syb_submodule A, syb_module B, syb_subject C "
			+ " WHERE C.SUBJECT_NAME = ? AND A.SUBMODULE_NAME IN ";
	
	public static final String GET_SUBMODULE_IDS_LAST = "AND A.MODULE_REF = B.SYB_SUB_MODULE_ID AND B.MODULE_SUBJECT_REF = C.IDSYB_SUBJECT";

	public static final String GET_LAST_INSERTED_ID = " SELECT LAST_INSERT_ID() ";

	public static final String INSERT_EXAM_SUBMODULE_MAP = "INSERT INTO exam_ques_submodule_map (QUESTION_ID, SUBMODULE_ID) VALUES (? , ?)";

	public static final String RETRIEVE_QUES_IMG = "SELECT QUES_IMG FROM exam_questions WHERE EXAM_QUESTIONS_ID = ?";

}
