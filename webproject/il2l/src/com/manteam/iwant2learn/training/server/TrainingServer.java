package com.manteam.iwant2learn.training.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.vo.QuestionReturnVO;

public class TrainingServer extends AbstractManager {
	
	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;

		try {

			subjectVOs = TrainingSql.getInstance().retrieveSubjectDetails(
					getConnection(), subjectName);
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
					.retrieveQuestionsForSelection(getConnection(),
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
	

}
