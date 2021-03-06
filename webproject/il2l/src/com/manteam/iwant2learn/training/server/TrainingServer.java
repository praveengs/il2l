package com.manteam.iwant2learn.training.server;

import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.QuestionSearchVO;

public class TrainingServer extends AbstractManager {
	
	public Collection<SubjectVO> retrieveSubjects(String subjectName, Collection<String> keyWords)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;

		try {

			if (keyWords != null) {
				subjectVOs = TrainingSql.getInstance().retrieveSubjectDetails(
						getConnection(), subjectName, keyWords);
			} else {
			subjectVOs = TrainingSql.getInstance().retrieveSubjectDetails(
					getConnection(), subjectName);
			}
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

	public QuestionReturnVO retrieveQuestionsForWeb(QuestionSearchVO questionSearchVO) throws SystemException {
		QuestionReturnVO questionReturnVO = null;

		try {

			questionReturnVO = TrainingSql.getInstance()
					.retrieveQuestionsForWeb(getConnection(),
							questionSearchVO);
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
