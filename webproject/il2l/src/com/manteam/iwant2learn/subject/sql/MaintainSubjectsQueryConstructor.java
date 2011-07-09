/**
 * 
 */
package com.manteam.iwant2learn.subject.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Praveen
 *
 */
public class MaintainSubjectsQueryConstructor {

	/**
	 * Method to get all the subjects defined in the system
	 * 
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement retrieveAllSubjects(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainSubjectsQueries.RETRIEVE_ALL_SUBJECTS);

		return preparedStatement;
	}

	public static PreparedStatement retrieveAllSubjectsnSubmodules(
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainSubjectsQueries.RETRIEVE_ALL_SUBJECTS_AND_SUBMODULES);

		return preparedStatement;
	}
}
