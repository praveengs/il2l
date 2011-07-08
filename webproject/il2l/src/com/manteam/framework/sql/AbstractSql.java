/**
 * 
 */
package com.manteam.framework.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Praveen
 * 
 */
public abstract class AbstractSql {
	

	public void close(PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}

	public void close(ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
	}
	
	public void close(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public void close(ResultSet resultSet, PreparedStatement preparedStatement)
			throws SQLException {
		close(resultSet);
		close(preparedStatement);
	}
	
	public void close(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement)
			throws SQLException {
		close(resultSet);
		close(preparedStatement);
		close(connection);
	}

}
