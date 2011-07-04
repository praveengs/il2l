/**
 * 
 */
package com.manteam.iwant2learn.questions.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

/**
 * @author Praveen
 * 
 */
public class MaintainQuestionSql extends AbstractSql {

	public int saveQuestion(Connection connection,
			ExamQuestionsVO examQuestionsVO, int submoduleId) throws SQLException {

		PreparedStatement preparedStatement = null;

		int rowsInserted = 0;
		try {
			preparedStatement = MaintainQuestionQueryConstructor.saveQuestion(
					examQuestionsVO, submoduleId, connection);
			rowsInserted = preparedStatement.executeUpdate();

		} finally {
			close(preparedStatement);
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
			close(resultSet, preparedStatement);
		}
		return submoduleId;
	}

}
