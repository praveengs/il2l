/**
 * 
 */
package com.manteam.framework.manager;

import java.sql.Connection;

import com.manteam.framework.db.ConnectionManager;
import com.manteam.framework.db.exceptions.DatabaseException;

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

}
