/**
 * 
 */
package com.manteam.iwant2learn.subject.sql;

/**
 * @author Praveen
 * 
 */
public abstract class MaintainSubjectsQueries {

	public static final String RETRIEVE_ALL_SUBJECTS = "select SUBJECT_NAME, "
			+ "SUBJECT_DESCRIPTION, " + "SUBJECT_WRITEUP from syb_subject";

	public static final String RETRIEVE_ALL_SUBJECTS_AND_SUBMODULES = "SELECT A.SUBJECT_NAME, C.SUBMODULE_NAME "
			+ "FROM syb_subject A, syb_module B, syb_submodule C "
			+ "WHERE B.MODULE_SUBJECT_REF = A.IDSYB_SUBJECT "
			+ "AND C.MODULE_REF = B.SYB_SUB_MODULE_ID ";

	public static final String GET_LAST_INSERTED_ID = "SELECT LAST_INSERT_ID() ";

	public static final String GET_MODULE_ID = "SELECT A.SYB_SUB_MODULE_ID " +
			"FROM syb_module A, syb_subject B " +
			"WHERE A.MODULE_NAME = ? AND A.MODULE_SUBJECT_REF = B.IDSYB_SUBJECT " +
			"AND B.SUBJECT_NAME = ?";

	public static final String SAVE_MODULE_DETAILS_FOR_SUBJECT = "INSERT INTO syb_module(MODULE_NAME, MODULE_SUBJECT_REF) " +
			"VALUES (?, (select IDSYB_SUBJECT FROM syb_subject WHERE subject_name = ?))";

	public static final String GET_SUBMODULE_ID = "SELECT C.SYB_SUB_SUBMODULE_ID " +
			"FROM syb_module A, syb_subject B, syb_submodule C " +
			"WHERE C.SUBMODULE_NAME = ? AND C.MODULE_REF = A.SYB_SUB_MODULE_ID " +
			"AND A.MODULE_SUBJECT_REF = B.IDSYB_SUBJECT " +
			"AND B.SUBJECT_NAME = ?";

	public static final String SAVE_SUBMODULE_DETAILS = "INSERT INTO syb_submodule (SUBMODULE_NAME, SUBMODULE_DESC, MODULE_REF) " +
			"values (?, ?, ?)";

}
