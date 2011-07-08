/**
 * 
 */
package com.manteam.iwant2learn.questions.server;

import java.sql.Connection;
import java.sql.SQLException;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionSql;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionsManager extends AbstractManager {

	private Connection connection = null;

	private Connection retrieveConnection() throws DatabaseException {
		if (connection == null) {
			connection = getConnection();
		}
		return connection;
	}

	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {

		boolean isInserted = false;
		try {

			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();
			int submoduleId = maintainQuestionSql.getSubmoduleId(
					retrieveConnection(), examQuestionsVO);
			if (submoduleId == -1) {
				throw new MaintainQuestionsException(
						MaintainQuestionsException.INVALID_SUBJ_MOD_SUBMOD_COMB);
			}
			int recordsUpdated = maintainQuestionSql.saveQuestion(
					retrieveConnection(), examQuestionsVO, submoduleId);
			if (recordsUpdated > 0) {
				isInserted = true;
			}
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return isInserted;
	}

}
