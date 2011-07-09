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
			+ "FROM SYB_SUBJECT A, SYB_MODULE B, SYB_SUBMODULE C "
			+ "WHERE B.MODULE_SUBJECT_REF = A.IDSYB_SUBJECT "
			+ "AND C.MODULE_REF = B.SYB_SUB_MODULE_ID ";

}
