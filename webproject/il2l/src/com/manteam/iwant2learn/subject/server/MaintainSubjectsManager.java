/**
 * 
 */
package com.manteam.iwant2learn.subject.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.subject.sql.MaintainSubjectsSql;

/**
 * @author Praveen
 * 
 */
public class MaintainSubjectsManager extends AbstractManager {

	MaintainSubjectsSql maintainSubjectsSql = null;

	/**
	 * 
	 * @return
	 * @throws SystemException
	 */
	public Collection<String> retrieveAllSubjects() throws SystemException {
		Collection<String> subjects = null;
		Connection conn;
		try {
			conn = getConnection();

			subjects = getMaintainSubjectsSql().retrieveAllSubjects(conn);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjects;
	}

	/**
	 * This method returns all the subjects and submodules associated with it
	 * in the form of a HashMap. This is used to populate the Question Creation
	 * screen
	 * 
	 * @return
	 * @throws SystemException
	 */
	public HashMap<String, ArrayList<String>> retrieveAllSubjectsnSubmodules()
			throws SystemException {
		HashMap<String, ArrayList<String>> subjectnSubmoduleMap = null;
		Connection conn;
		try {
			conn = getConnection();

			subjectnSubmoduleMap = getMaintainSubjectsSql()
					.retrieveAllSubjectsnSubmodules(conn);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjectnSubmoduleMap;
	}

	private MaintainSubjectsSql getMaintainSubjectsSql() {
		if (maintainSubjectsSql == null) {
			maintainSubjectsSql = new MaintainSubjectsSql();
		}
		return maintainSubjectsSql;
	}
}
