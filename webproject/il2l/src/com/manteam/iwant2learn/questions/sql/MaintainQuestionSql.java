/**
 * 
 */
package com.manteam.iwant2learn.questions.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionSql extends AbstractSql {

	public int saveQuestion(Connection connection,
			ExamQuestionsVO examQuestionsVO, int submoduleId)
			throws SQLException {

		PreparedStatement preparedStatement = null;

		int rowsInserted = 0;
		try {
			preparedStatement = MaintainQuestionQueryConstructor.saveQuestion(
					examQuestionsVO, submoduleId, connection);
			rowsInserted = preparedStatement.executeUpdate();

		} finally {
			close(preparedStatement);
			close(connection);
		}
		return rowsInserted;
	}

	/**
	 * This method returns the submodule id for the subjectname, modulename,
	 * submodulename combination.
	 * 
	 * -1 is returned if id is not found
	 * 
	 * @param connection
	 * @param examQuestionsVO
	 * @return
	 * @throws SQLException
	 */
	public int getSubmoduleId(Connection connection,
			ExamQuestionsVO examQuestionsVO) throws SQLException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int submoduleId = -1;
		try {
			preparedStatement = MaintainQuestionQueryConstructor
					.getSubmoduleId(examQuestionsVO.getSubjectName(),
							examQuestionsVO.getModuleName(),
							examQuestionsVO.getSubmoduleName(), connection);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				submoduleId = resultSet
						.getInt(MaintainQuestionsQueryConstants.SYB_SUB_SUBMODULE_ID);
			}
		} finally {
			// connection is not closed here because the
			// same connection is used for a different purpose in sql class
			close(resultSet, preparedStatement);
		}
		return submoduleId;
	}

	public HashMap<Integer, String> getSubmoduleIds(Connection connection,
			String subjectName, Collection<String> submodules)
			throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		HashMap<Integer, String> idSubmoduleMap = null;

		try {
			preparedStatement = MaintainQuestionQueryConstructor
					.getSubmoduleIds(subjectName, submodules, connection);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				do {
					if (idSubmoduleMap == null) {
						idSubmoduleMap = new HashMap<Integer, String>(2);
					}
					idSubmoduleMap
							.put(resultSet
									.getInt(MaintainQuestionsQueryConstants.SYB_SUB_SUBMODULE_ID),
									resultSet
											.getString(MaintainQuestionsQueryConstants.SUBMODULE_NAME));
				} while (resultSet.next());
			}
		} finally {
			// connection is not closed here because the
			// same connection is used for a different purpose in sql class
			close(resultSet, preparedStatement);
		}
		return idSubmoduleMap;

	}

	public int saveQuestion(Connection conn, QuestionSaveVO questionSaveVO,
			Set<Integer> submoduleIds, LogonAttributesVO logonAttributesVO, Date date)
			throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int rowsInserted = 0;
		try {
			preparedStatement = MaintainQuestionQueryConstructor.saveQuestion(
					questionSaveVO, submoduleIds, conn,
					logonAttributesVO.getUserName(),
					logonAttributesVO.getUserRole(), date);
			rowsInserted = preparedStatement.executeUpdate();
			//preparedStatement.close();

			System.out.println("Rows Inserted"+rowsInserted);
			if (rowsInserted > 0) {
				preparedStatement = MaintainQuestionQueryConstructor
						.getLastInsertedId(conn);
				resultSet = preparedStatement.executeQuery();
				long lastQuestionId = 0;
				if (resultSet.next()) {
					lastQuestionId = resultSet.getLong(MaintainQuestionsQueryConstants.LAST_INSERTED_ID);
				}
				//int lastQuestionId = resultSet.getInt(1);
				System.out.println("Last Question Id Inserted: "+lastQuestionId);
				//preparedStatement.close();
				//resultSet.close();

				preparedStatement = MaintainQuestionQueryConstructor
						.saveQuestionSubmoduleMap((int) lastQuestionId, submoduleIds,
								conn);
				preparedStatement.executeBatch();
			}

		} finally {
			close(preparedStatement);
		}
		return rowsInserted;
	}

}
