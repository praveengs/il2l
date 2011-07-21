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
import com.manteam.iwant2learn.subject.exceptions.MaintainSubjectsException;
import com.manteam.iwant2learn.subject.sql.MaintainSubjectsSql;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;

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
	 * This method returns all the subjects and submodules associated with it in
	 * the form of a HashMap. This is used to populate the Question Creation
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

	public int saveModulenSubmodule(SubmoduleSaveVO submoduleSaveVO)
			throws MaintainSubjectsException, SystemException {
		Connection conn = null;
		int submoduleId = 0;
		try {
			conn = getConnection();

			conn.setAutoCommit(false);
			int moduleId = getMaintainSubjectsSql().getModuleID(conn,
					submoduleSaveVO.getModuleName(),
					submoduleSaveVO.getSubjectName());
			if (moduleId == 0) {
				throw new MaintainSubjectsException(
						MaintainSubjectsException.INVALID_MODULE_ID);
			}
			submoduleId = getSubmoduleForSubject(
					submoduleSaveVO.getSubjectName(),
					submoduleSaveVO.getSubmoduleName());
			if (submoduleId != 0) {
				throw new MaintainSubjectsException(
						MaintainSubjectsException.SUBMODULE_ALREADY_PRESENT
								+ submoduleId);
			}
			submoduleId = getMaintainSubjectsSql().saveSubmodule(conn,
					moduleId, submoduleSaveVO);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return submoduleId;
	}
	
	public int getSubmoduleForSubject (String subjectName, String submoduleName) throws SystemException {
		int submoduleId = 0;
		try {
			submoduleId = getMaintainSubjectsSql().getSubmoduleForSubject(getConnection(),
					subjectName,
					submoduleName);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		}
		return submoduleId;
	}
	
	/**
	 * This method returns all the subjects, submodules and the keywords associated 
	 * with it. This is used to populate the Question Creation
	 * screen
	 * 
	 * @return
	 * @throws SystemException
	 */
	public HashMap<String, HashMap<String, ArrayList<String>>> retrieveAllSubjectDetailsForAddQuestion()
			throws SystemException {
		HashMap<String, HashMap<String, ArrayList<String>>> subjectnSubmodulenKeyWordMap = null;
		Connection conn;
		try {
			conn = getConnection();

			subjectnSubmodulenKeyWordMap = getMaintainSubjectsSql()
					.retrieveAllSubjectDetailsForAddQuestion(conn);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjectnSubmodulenKeyWordMap;
	}

	/**
	 * This method returns all the keywords attached with a particular 
	 * subject
	 * 
	 * @param subjectName
	 * @return
	 * @throws SystemException
	 */
	public Collection<String> retrieveKeyWordsForSubject(String subjectName) throws SystemException {
		Collection<String> keyWords = null;
		Connection conn;
		try {
			conn = getConnection();

			keyWords = getMaintainSubjectsSql()
					.retrieveAllKeyWordsForSubject(conn, subjectName);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return keyWords;
	}
}
