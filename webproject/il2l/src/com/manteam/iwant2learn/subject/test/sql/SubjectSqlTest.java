package com.manteam.iwant2learn.subject.test.sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.iwant2learn.subject.sql.MaintainSubjectsSql;

public class SubjectSqlTest {

	public static void main(String[] args) {
		SubjectSqlTest sqlTest = new SubjectSqlTest();
		sqlTest.testRetrieveSubjectsnSubmodules();
	}

	public void testRetrieveSubjectsnSubmodules() {
		HashMap<String, ArrayList<String>> subjectsnSubmodulesMap = null;
		try {
			MaintainSubjectsSql maintainSubjectsSql = new MaintainSubjectsSql();
			subjectsnSubmodulesMap = maintainSubjectsSql
					.retrieveAllSubjectsnSubmodules(ConnectionManager
							.getInstance().getNewConnection());
			//System.out.println(subjectsnSubmodulesMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(subjectsnSubmodulesMap);
	}
}
