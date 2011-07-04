/**
 * 
 */
package com.manteam.iwant2learn.questions.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionSql;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.SubjectVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionsManager {

	private Connection connection = null;

	private Connection getConnection() throws DatabaseException {
		if (connection == null) {
			connection = ConnectionManager.getInstance().getConnection();
		}
		return connection;
	}

	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {
		Connection conn;
		boolean isInserted = false;
		try {
			conn = getConnection();

			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();
			int submoduleId = maintainQuestionSql.getSubmoduleId(conn,
					examQuestionsVO);
			if (submoduleId == -1) {
				throw new MaintainQuestionsException(
						MaintainQuestionsException.INVALID_SUBJ_MOD_SUBMOD_COMB);
			}
			int recordsUpdated = maintainQuestionSql.saveQuestion(conn,
					examQuestionsVO, submoduleId);
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
