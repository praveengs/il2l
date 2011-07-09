package com.manteam.iwant2learn.training.test.sql;

import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.training.util.WebXMLCreator;

public class TrainingSqlTest {

	public static void main(String[] args) {
		TrainingSqlTest sqlTest = new TrainingSqlTest();
		sqlTest.testRetrieveSubjects();
	}

	public void testRetrieveSubjects() {
		Collection<SubjectVO> subjectVOs = null;
		try {
			subjectVOs = TrainingSql.getInstance().retrieveSubjectDetails(
					ConnectionManager.getInstance().getNewConnection(), "Physics");
			for (SubjectVO subjectVO:subjectVOs) {
				WebXMLCreator.createXMLStreamForWebClient(subjectVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(subjectVOs);
	}
}
