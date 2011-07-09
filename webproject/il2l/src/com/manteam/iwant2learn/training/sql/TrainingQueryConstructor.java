package com.manteam.iwant2learn.training.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.manteam.iwant2learn.vo.ModuleVO;
import com.manteam.iwant2learn.vo.SubjectVO;

public class TrainingQueryConstructor {

	public static PreparedStatement retrieveSubjects(String subjectName,
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
		for (ModuleVO moduleVO : subjectVO.getModules()) {
			query.append("(");
			for (String submodule : moduleVO.getSubmodules()) {
				query.append("'").append(submodule)
						.append("',");
			}
			query.replace(query.length() - 1, query.length(), ")");

		}
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
		for (ModuleVO moduleVO : subjectVO.getModules()) {
			query.append("(");
			for (String submodule : moduleVO.getSubmodules()) {
				query.append("'").append(submodule).append("',");
			}
			query.replace(query.length() - 1, query.length(), ")");

		}
		query.append(TrainingQueries.GET_KEYWORD_FOR_SUBMODULES_REST);
		System.out.println(query);
		preparedStatement = connection.prepareStatement(query.toString());
		preparedStatement.setString(1, subjectVO.getSubjectName());

		return preparedStatement;
	}

	public static PreparedStatement retrieveAllSubjects(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(TrainingQueries.RETRIEVE_ALL_SUBJECTS);

		return preparedStatement;
	}

}
