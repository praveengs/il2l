/**
 * 
 */
package com.manteam.iwant2learn.user.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.user.exceptions.MaintainUserException;
import com.manteam.iwant2learn.user.sql.MaintainUserSql;
import com.manteam.iwant2learn.user.vo.LoginVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.user.vo.UserSaveVO;

/**
 * @author Praveen
 * 
 */
public class MaintainUserManager extends AbstractManager {

	/**
	 * This method is used to authenticate a user logged into the system. If the
	 * user exists, a logon attributes VO is filled and send back. Else an
	 * exception is thrown
	 * 
	 * @param loginVO
	 * @return
	 * @throws MaintainUserException
	 * @throws SystemException
	 */
	public LogonAttributesVO authenticateUser(LoginVO loginVO)
			throws MaintainUserException, SystemException {
		LogonAttributesVO logonAttributesVO = null;
		MaintainUserSql maintainUserSql = new MaintainUserSql();

		try {
			logonAttributesVO = maintainUserSql.retrieveUserDetails(
					getConnection(), loginVO);

			if (logonAttributesVO == null) {
				throw new MaintainUserException(
						MaintainUserException.USER_DOES_NOT_EXIST);
			}
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		}

		return logonAttributesVO;
	}

	/**
	 * This method is used to save the user details
	 * 
	 * @param logonAttributesVO
	 * @param userSaveVO
	 * @return
	 * @throws MaintainUserException
	 * @throws SystemException
	 */
	public boolean addUser(LogonAttributesVO logonAttributesVO,
			UserSaveVO userSaveVO) throws MaintainUserException,
			SystemException {
		int userId = 0;
		boolean isUserAdded = false;
		Connection conn = null;
		MaintainUserSql maintainUserSql = new MaintainUserSql();
		try {
			userId = maintainUserSql.retrieveUserIdForUserName(getConnection(),
					userSaveVO.getUserName());

			if (userId > 0) {
				throw new MaintainUserException(
						MaintainUserException.USERNAME_ALREADY_EXISTS);
			}
			conn = getConnection();
			conn.setAutoCommit(false);
			userId = maintainUserSql.addUser(conn, logonAttributesVO,
					userSaveVO, new Date());
			if (userId > 0) {
				isUserAdded = true;
			}
			conn.commit();
			conn.setAutoCommit(true);
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
		} catch (DatabaseException databaseException) {
			throw new SystemException(SystemException.CONNECTION_UNAVAILABLE,
					databaseException);
		}
		return isUserAdded;
	}
}
