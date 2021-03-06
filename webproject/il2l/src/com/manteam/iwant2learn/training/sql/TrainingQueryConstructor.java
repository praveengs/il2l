package com.manteam.iwant2learn.training.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import com.manteam.iwant2learn.subject.vo.ModuleVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.QuestionSearchVO;

public class TrainingQueryConstructor {

	public static PreparedStatement retrieveSubjectDetails(String subjectName,
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(TrainingQueries.RETRIEVE_SUBJECT_DETAILS);
		preparedStatement.setString(1, subjectName);
		return preparedStatement;
	}

	/**
	 * 
	 * @param subjectVOs
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement retrieveQuestions(SubjectVO subjectVO,
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.RETRIEVE_QUESTIONS_SUBMOD);
		query.append("(");
		for (ModuleVO moduleVO : subjectVO.getModules()) {
			for (String submodule : moduleVO.getSubmodules()) {
				query.append("'").append(submodule).append("',");
			}
		}
		query.replace(query.length() - 1, query.length(), ")");
		query.append(TrainingQueries.RETRIEVE_QUESTIONS_REST);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		preparedStatement.setString(1, subjectVO.getSubjectName());

		return preparedStatement;
	}

	public static PreparedStatement retrieveKeyWordsForSubmodulesofSubject(
			SubjectVO subjectVO, Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.GET_KEYWORD_FOR_SUBMODULES);
		query.append("(");
		for (ModuleVO moduleVO : subjectVO.getModules()) {

			for (String submodule : moduleVO.getSubmodules()) {
				query.append("'").append(submodule).append("',");
			}

		}
		query.replace(query.length() - 1, query.length(), ")");
		query.append(TrainingQueries.GET_KEYWORD_FOR_SUBMODULES_REST);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		preparedStatement.setString(1, subjectVO.getSubjectName());

		return preparedStatement;
	}

	public static PreparedStatement retrieveQuestionsForWeb(
			QuestionSearchVO questionSearchVO, Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.RETRIEVE_QUESTIONS_SUBMOD);
		query.append("(");
		for (String submodule : questionSearchVO.getSubmodules()) {

			query.append("'").append(submodule).append("',");

		}
		query.replace(query.length() - 1, query.length(), ")");
		query.append(TrainingQueries.RETRIEVE_QUESTIONS_REST);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		preparedStatement.setString(1, questionSearchVO.getSubjectName());

		return preparedStatement;
	}

	public static PreparedStatement retrieveKeyWordsForSubmodulesofSubject(
			QuestionSearchVO questionSearchVO, Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.GET_KEYWORD_FOR_SUBMODULES);
		query.append("(");
		for (String submodule : questionSearchVO.getSubmodules()) {
			query.append("'").append(submodule).append("',");
		}
		query.replace(query.length() - 1, query.length(), ")");
		query.append(TrainingQueries.GET_KEYWORD_FOR_SUBMODULES_REST);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		preparedStatement.setString(1, questionSearchVO.getSubjectName());

		return preparedStatement;
	}

	public static PreparedStatement retrieveKeyWordsForQuestions(
			Connection connection, Collection<ExamQuestionsVO> examQuestionVOs)
			throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.GET_KEYWORD_FOR_QUESTIONS);
		query.append("(");
		for (ExamQuestionsVO examQuestionsVO : examQuestionVOs) {
			query.append("'").append(examQuestionsVO.getQuestionId())
					.append("',");
		}
		query.replace(query.length() - 1, query.length(), ")");
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		return preparedStatement;
	}

	public static PreparedStatement retrieveSubjectDetailsForKeyWords(
			String subjectName, Collection<String> keyWords,
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement;
		StringBuilder query = new StringBuilder(
				TrainingQueries.RETRIEVE_SUBJECT_DETAILS_WITH_KEYWORD);
		query.append("(");
		for (String keyword: keyWords) {
			query.append("'").append(keyword.toUpperCase())
			.append("',");
		}
		query.replace(query.length() - 1, query.length(), ")");
		preparedStatement = connection
				.prepareStatement(query.toString());
		preparedStatement.setString(1, subjectName);
		return preparedStatement;
	}

}
