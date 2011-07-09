package com.manteam.iwant2learn.questions.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

public class MaintainQuestionQueryConstructor {

	public static PreparedStatement saveQuestion(
			ExamQuestionsVO examQuestionsVO, int submoduleId,
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainQuestionQueries.INSERT_QUESTION);
		preparedStatement.setInt(1, submoduleId);
		preparedStatement.setString(2, examQuestionsVO.getQuestion());
		if (examQuestionsVO.getQuestionImage() != null) {
			preparedStatement.setBinaryStream(3,
					examQuestionsVO.getQuestionImage());
		} else {
			preparedStatement.setBinaryStream(3, null);
		}
		preparedStatement.setString(4,
				examQuestionsVO.getQuestionYearMarkString());
		preparedStatement.setString(5, examQuestionsVO.getAnswer());
		if (examQuestionsVO.getAnswerImageStream() != null) {
			preparedStatement.setBinaryStream(6,
					examQuestionsVO.getAnswerImageStream());
		} else {
			preparedStatement.setBinaryStream(6, null);
		}
		return preparedStatement;
	}

	public static PreparedStatement getSubmoduleId(String subjectName,
			String moduleName, String submoduleName, Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainQuestionQueries.GET_SUBMODULE_ID);
		preparedStatement.setString(1, subjectName);
		preparedStatement.setString(2, moduleName);
		preparedStatement.setString(3, submoduleName);
		return preparedStatement;
	}

	public static PreparedStatement getSubmoduleIds(String subjectName,
			Collection<String> submodules, Connection connection)
			throws SQLException {
		StringBuilder queryBuilder = new StringBuilder(
				MaintainQuestionQueries.GET_SUBMODULE_IDS_FIRST);
		queryBuilder.append("(");
		for (String submodule : submodules) {
			queryBuilder.append("'").append(submodule).append("',");
		}
		queryBuilder.replace(queryBuilder.length() - 1, queryBuilder.length(),
				")");
		queryBuilder.append(MaintainQuestionQueries.GET_SUBMODULE_IDS_LAST);
		PreparedStatement preparedStatement = connection
				.prepareStatement(queryBuilder.toString());
		preparedStatement.setString(1, subjectName);
		return preparedStatement;
	}

	public static PreparedStatement saveQuestion(QuestionSaveVO questionSaveVO,
			Set<Integer> submoduleIds, Connection connection, String userName,
			String userRole, Date date) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainQuestionQueries.INSERT_QUESTION);

		preparedStatement.setString(1, questionSaveVO.getQuestion());
		if (questionSaveVO.getQuestionImage() != null) {
			preparedStatement.setBinaryStream(2,
					questionSaveVO.getQuestionImage());
		} else {
			preparedStatement.setBinaryStream(2, null);
		}
		preparedStatement.setString(3,
				questionSaveVO.getQuestionYearMarkString());
		preparedStatement.setString(4, questionSaveVO.getAnswer());
		if (questionSaveVO.getAnswerImageStream() != null) {
			preparedStatement.setBinaryStream(5,
					questionSaveVO.getAnswerImageStream());
		} else {
			preparedStatement.setBinaryStream(5, null);
		}
		//LAST_MODIFIED_BY, LAST_MODIFIED_DATE, LAST_MODIFIED_ROLE
		preparedStatement.setString(6, userName);
		preparedStatement.setTimestamp(7, new Timestamp(date.getTime()));
		preparedStatement.setString(8, userRole);
		return preparedStatement;
	}

	public static PreparedStatement getLastInsertedId(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainQuestionQueries.GET_LAST_INSERTED_ID);
		return preparedStatement;
	}

	public static PreparedStatement saveQuestionSubmoduleMap(
			int lastQuestionId, Set<Integer> submoduleIds, Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainQuestionQueries.INSERT_EXAM_SUBMODULE_MAP);
		for (Integer submoduleId : submoduleIds) {
			preparedStatement.setInt(1, lastQuestionId);
			preparedStatement.setInt(2, submoduleId.intValue());
			preparedStatement.addBatch();
		}

		return preparedStatement;
	}

}
