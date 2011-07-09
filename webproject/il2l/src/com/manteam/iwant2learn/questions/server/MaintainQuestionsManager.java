/**
 * 
 */
package com.manteam.iwant2learn.questions.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionSql;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionsManager extends AbstractManager {

	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {

		boolean isInserted = false;
		try {

			Connection conn = getConnection();
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

	public boolean saveQuestionForSubmodules(
			LogonAttributesVO logonAttributesVO, QuestionSaveVO questionSaveVO)
			throws SystemException, MaintainQuestionsException {

		Connection conn = null;
		boolean isInserted = false;
		try {
			conn = getConnection();

			MaintainQuestionSql maintainQuestionSql = new MaintainQuestionSql();			

			HashMap<Integer, String> submoduleIdMap = maintainQuestionSql
					.getSubmoduleIds(conn, questionSaveVO.getSubjectName(),
							questionSaveVO.getSubmodules());

			if (submoduleIdMap.containsKey(null)) {
				throw new MaintainQuestionsException(
						MaintainQuestionsException.INVALID_SUBJ_SUBMOD_COMB);
			}
			conn.setAutoCommit(false);
			int recordsUpdated = maintainQuestionSql.saveQuestion(conn,
					questionSaveVO, submoduleIdMap.keySet(), logonAttributesVO, new Date());
			if (recordsUpdated > 0) {
				isInserted = true;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (DatabaseException databaseException) {
			// TODO Auto-generated catch block
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return isInserted;
	}

}
