package com.manteam.iwant2learn.keywords.sql;

public abstract class KeyWordMaintenanceQueries {

	public static final String INSERT_KEYWORD = "INSERT INTO syb_keyword (KEYWORD, KEYWORD_DESC, KEYWORD_IMAGE, LAST_MODIFIED_BY, LAST_MODIFIED_ROLE, LAST_MODIFIED_DATE) "
			+ "values (?, ?, ?, ?, ? , ?)";

	public static final String GET_KEYWORD_ID = "SELECT A.SYB_KEYWORD_ID "
			+ "FROM syb_keyword A, sub_keyword_submodule_map B, syb_submodule C, syb_module D, syb_subject E "
			+ "where A.KEYWORD = ? " + "and A.SYB_KEYWORD_ID = B.KEYWORD_ID "
			+ "and B.SUBMODULE_ID = C.SYB_SUB_SUBMODULE_ID "
			+ "and C.SUBMODULE_NAME = ? "
			+ "and C.MODULE_REF = D.SYB_SUB_MODULE_ID "
			+ "and D.MODULE_SUBJECT_REF = E.IDSYB_SUBJECT "
			+ "and E.SUBJECT_NAME = ? ";

	public static final String GET_LAST_INSERTED_ID = " SELECT LAST_INSERT_ID() ";

	public static final String INSERT_KEYWORD_SUBMODULE_MAP = "INSERT INTO sub_keyword_submodule_map (KEYWORD_ID, SUBMODULE_ID) "
			+ "values (?, ?)";

}
