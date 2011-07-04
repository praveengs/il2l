package com.manteam.iwant2learn.training.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.SubjectVO;

public class TrainingServer {
	Connection connection = null;

	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;
		Connection conn;
		try {
			conn = getConnection();

			subjectVOs = TrainingSql.getInstance().retrieveSubjects(conn,
					subjectName);
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjectVOs;
	}

	/**
	 * This method returns the questions for the selected modules, submodules
	 * of a particular subject
	 * 
	 * @param subjectVO
	 * @return
	 * @throws SystemException
	 */
	public QuestionReturnVO retrieveQuestions(SubjectVO subjectVO)
			throws SystemException {
		QuestionReturnVO questionReturnVO = null;
		Connection conn;
		try {
			conn = getConnection();

			questionReturnVO = TrainingSql.getInstance()
					.retrieveQuestionsForSelection(conn, subjectVO);
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return questionReturnVO;
	}
        
        /**
         * 
         * @return
         * @throws SystemException 
         */
	public Collection<String> retrieveAllSubjects()
			throws SystemException {
		Collection<String> subjects = null;
		Connection conn;
		try {
			conn = getConnection();

			subjects = TrainingSql.getInstance()
					.retrieveAllSubjects(conn);
		} catch (DatabaseException databaseException) {			
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjects;
	}

	private Connection getConnection() throws DatabaseException {
		if (connection == null) {
			connection = ConnectionManager.getInstance().getConnection();
		}
		return connection;
	}
}
