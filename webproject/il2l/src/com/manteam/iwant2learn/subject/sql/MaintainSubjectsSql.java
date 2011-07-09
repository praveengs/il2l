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

}
