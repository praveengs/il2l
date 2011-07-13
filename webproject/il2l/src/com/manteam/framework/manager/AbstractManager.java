/**
 * 
 */
package com.manteam.framework.manager;

import java.sql.Connection;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

/**
 * @author Praveen
 * 
 */
public abstract class AbstractManager {
	public static final String CLIENT_APP_MODE = "CLIENT";
	public static final String WEB_APP_MODE = "WEBSERVER";

	private String mode;

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public AbstractManager() {
		setMode(WEB_APP_MODE);
	}

	protected Connection getConnection() throws DatabaseException {
		Connection connection = null;
		if (WEB_APP_MODE.equals(getMode())) {
			connection = ConnectionManager.getInstance().getConnection();
		} else {
			connection = ConnectionManager.getInstance().getNewConnection();
		}
		return connection;
	}
	
	protected LogonAttributesVO getLogonAttributesVO() {
		LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
		if (WEB_APP_MODE.equals(getMode())) {
			logonAttributesVO.setUserName("System Web User");
			logonAttributesVO.setUserRole("System Web Role");
		} else {
			logonAttributesVO.setUserName("System Client User");
			logonAttributesVO.setUserRole("System Client Role");
		}
		return logonAttributesVO;
	}

}
