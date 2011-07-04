package com.manteam.iwant2learn.questions.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
