/**
 * 
 */
package com.manteam.iwant2learn.subject.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionQueryConstructor;
import com.manteam.iwant2learn.questions.sql.MaintainQuestionsQueryConstants;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;

/**
 * @author Praveen
 * 
 */
public class MaintainSubjectsSql extends AbstractSql {

	public Collection<String> retrieveAllSubjects(Connection connection)
			throws SQLException {
		Collection<String> subjects = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = MaintainSubjectsQueryConstructor
					.retrieveAllSubjects(connection);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				do {
					if (subjects == null) {
						subjects = new ArrayList<String>(2);
					}
					subjects.add(resultSet
							.getString(MaintainSubjectsQueryConstants.SUBJECT_NAME));
				} while (resultSet.next());
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}

		return subjects;
	}

	public HashMap<String, ArrayList<String>> retrieveAllSubjectsnSubmodules(
			Connection connection) throws SQLException {
		HashMap<String, ArrayList<String>> subjectnSubmoduleMap = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = MaintainSubjectsQueryConstructor
					.retrieveAllSubjectsnSubmodules(connection);
			resultSet = preparedStatement.executeQuery();
			String subject = null;
			ArrayList<String> submodules = null;
			if (resultSet.next()) {
				subjectnSubmoduleMap = new HashMap<String, ArrayList<String>>(2);
				do {
					subject = resultSet
							.getString(MaintainSubjectsQueryConstants.SUBJECT_NAME);
					submodules = subjectnSubmoduleMap.get(subject);
					if (submodules == null) {
						submodules = new ArrayList<String>(2);
						subjectnSubmoduleMap.put(subject, submodules);
					}
					submodules
							.add(resultSet
									.getString(MaintainSubjectsQueryConstants.SUBMODULE_NAME));
				} while (resultSet.next());
			}
		} finally {
			close(connection, resultSet, preparedStatement);
		}

		return subjectnSubmoduleMap;
	}

	public int getModuleID(Connection conn, String moduleName,
			String subjectName) throws SQLException {
		int moduleId = 0;
		// int subjectId = 0;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = MaintainSubjectsQueryConstructor.getModuleId(
					conn, moduleName, subjectName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				moduleId = resultSet
						.getInt(MaintainSubjectsQueryConstants.SYB_SUB_MODULE_ID);
				// subjectId =
				// resultSet.getInt(MaintainSubjectsQueryConstants.IDSYB_SUBJECT);
			}
			if (moduleId == 0) {
				preparedStatement = MaintainSubjectsQueryConstructor
						.saveModule(conn, moduleName, subjectName);
				int rowsInserted = preparedStatement.executeUpdate();
				if (rowsInserted > 0) {
					preparedStatement = MaintainSubjectsQueryConstructor
							.getLastInsertedId(conn);
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						moduleId = (int) resultSet
								.getLong(MaintainSubjectsQueryConstants.LAST_INSERTED_ID);
					}
				}
			}
		} finally {
			close(resultSet, preparedStatement);
		}
		return moduleId;
	}

	public int saveSubmodule(Connection conn, int moduleId,
			SubmoduleSaveVO submoduleSaveVO) throws SQLException {
		int submoduleId = 0;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = MaintainSubjectsQueryConstructor.saveSubModule(
					conn, moduleId, submoduleSaveVO);
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				preparedStatement = MaintainSubjectsQueryConstructor
						.getLastInsertedId(conn);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					submoduleId = (int) resultSet
							.getLong(MaintainSubjectsQueryConstants.LAST_INSERTED_ID);
				}
			}

		} finally {
			close(resultSet, preparedStatement);
		}
		return submoduleId;
	}

	public int getSubmoduleForSubject(Connection conn, String subjectName,
			String submoduleName) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int submoduleId = 0;
		try {
			preparedStatement = MaintainSubjectsQueryConstructor
					.getSubModuleId(conn, subjectName, submoduleName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				submoduleId = resultSet
						.getInt(MaintainSubjectsQueryConstants.SYB_SUB_SUBMODULE_ID);
				// subjectId =
				// resultSet.getInt(MaintainSubjectsQueryConstants.IDSYB_SUBJECT);
			}
		} finally {
			close(conn, resultSet, preparedStatement);
		}
		return submoduleId;
	}

}
