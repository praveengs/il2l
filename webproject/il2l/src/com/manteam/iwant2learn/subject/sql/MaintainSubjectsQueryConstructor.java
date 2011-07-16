/**
 * 
 */
package com.manteam.iwant2learn.subject.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.manteam.iwant2learn.questions.sql.MaintainQuestionQueries;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;

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

	public static PreparedStatement getLastInsertedId(Connection connection)
			throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainSubjectsQueries.GET_LAST_INSERTED_ID);
		return preparedStatement;
	}

	public static PreparedStatement getModuleId(Connection conn,
			String moduleName, String subjectName) throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement(MaintainSubjectsQueries.GET_MODULE_ID);
		preparedStatement.setString(1, moduleName);
		preparedStatement.setString(2, subjectName);

		return preparedStatement;
	}

	public static PreparedStatement saveModule(Connection conn,
			String moduleName, String subjectName) throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement(MaintainSubjectsQueries.SAVE_MODULE_DETAILS_FOR_SUBJECT);
		preparedStatement.setString(1, moduleName);
		preparedStatement.setString(2, subjectName);

		return preparedStatement;
	}

	public static PreparedStatement getSubModuleId(Connection conn,
			String subjectName, String submoduleName) throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement(MaintainSubjectsQueries.GET_SUBMODULE_ID);
		preparedStatement.setString(1, submoduleName);
		preparedStatement.setString(2, subjectName);

		return preparedStatement;
	}

	public static PreparedStatement saveSubModule(Connection conn,
			int moduleId, SubmoduleSaveVO submoduleSaveVO) throws SQLException {
		PreparedStatement preparedStatement = conn
				.prepareStatement(MaintainSubjectsQueries.SAVE_SUBMODULE_DETAILS);
		preparedStatement.setString(1, submoduleSaveVO.getSubmoduleName());
		preparedStatement.setString(2, submoduleSaveVO.getSubmoduleDescription());
		preparedStatement.setInt(3, moduleId);
		/*if (submoduleSaveVO.getDescriptionImage() != null) {
			preparedStatement.setBinaryStream(3, submoduleSaveVO.getDescriptionImage());
		} else {
			preparedStatement.setBinaryStream(3, null, (int)0);
		}*/

		return preparedStatement;
	}

	public static PreparedStatement retrieveAllSubjectDetailsForAddQuestion(
			Connection connection) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(MaintainSubjectsQueries.RETRIEVE_ALL_SUBJECTS_SUBMODULES_KEYWORDS);

		return preparedStatement;
	}
}
