package com.manteam.iwant2learn.training.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.SubjectVO;

public class TrainingServer extends AbstractManager {
	Connection connection = null;

	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;

		try {

			subjectVOs = TrainingSql.getInstance().retrieveSubjects(
					retrieveConnection(), subjectName);
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
	 * This method returns the questions for the selected modules, submodules of
	 * a particular subject
	 * 
	 * @param subjectVO
	 * @return
	 * @throws SystemException
	 */
	public QuestionReturnVO retrieveQuestions(SubjectVO subjectVO)
			throws SystemException {
		QuestionReturnVO questionReturnVO = null;

		try {

			questionReturnVO = TrainingSql.getInstance()
					.retrieveQuestionsForSelection(retrieveConnection(),
							subjectVO);
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
	public Collection<String> retrieveAllSubjects() throws SystemException {
		Collection<String> subjects = null;
		Connection conn;
		try {
			conn = getConnection();

			subjects = TrainingSql.getInstance().retrieveAllSubjects(conn);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjects;
	}

	private Connection retrieveConnection() throws DatabaseException {
		if (connection == null) {
			connection = getConnection();
		}
		return connection;
	}

}
