package com.manteam.framework.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.manteam.framework.db.exceptions.DatabaseException;
import com.manteam.framework.util.ReadXML;
import com.manteam.framework.util.XMLReadException;

public class ConnectionManager {
	private static final String COLON_SEPARATOR = ":";
	private static final String DOUBLE_SLASH_SEPARATOR = "//";
	private static final String SINGLE_SLASH_SEPARATOR = "/";
	private static ConnectionManager connectionManager = null;

	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConnection() throws DatabaseException {
		Connection conn = null;
		ConnectionDetails connectionDetails;
		// String userName = "";
		// String password = "";
		String url = "";
		try {
			connectionDetails = getConnectionDetailsFromSystemFile(new File(
					"config/DBConfig.xml"));

			//System.out.println(connectionDetails);
			url = buildUrl(connectionDetails.getDbType(),
					connectionDetails.getHost(), connectionDetails.getPort(),
					connectionDetails.getDbschema());

			// userName = "appuser";
			// password = "appuser";
			// url = "jdbc:mysql://localhost:3306/syllabus";
			if (DBProperties.MYSQL_TYPE.equals(connectionDetails.getDbType())) {
				Class.forName(DBProperties.MYSQL_DRIVER).newInstance();
			}
			conn = DriverManager.getConnection(url,
					connectionDetails.getDbUserName(),
					connectionDetails.getDbPassword());

		} catch (InstantiationException instantiationException) {
			// TODO Auto-generated catch block
			instantiationException.printStackTrace();
			throw new DatabaseException(DatabaseException.DATABASE_UNAVAILABLE,
					instantiationException);
		} catch (IllegalAccessException illegalAccessException) {
			// TODO Auto-generated catch block
			illegalAccessException.printStackTrace();
			throw new DatabaseException(DatabaseException.DATABASE_UNAVAILABLE,
					illegalAccessException);
		} catch (ClassNotFoundException classNotFoundException) {
			// TODO Auto-generated catch block
			classNotFoundException.printStackTrace();
			throw new DatabaseException(
					DatabaseException.DATABASE_DRIVER_UNAVAILABLE,
					classNotFoundException);
		} catch (XMLReadException xmlReadException) {
			// TODO Auto-generated catch block
			xmlReadException.printStackTrace();
			throw new DatabaseException(
					DatabaseException.DATABASE_CONFIG_EXCEPTION,
					xmlReadException);
		} catch (SQLException sqlException) {
			// TODO Auto-generated catch block
			sqlException.printStackTrace();
			throw new DatabaseException(DatabaseException.DATABASE_UNAVAILABLE,
					sqlException);
		}
		System.out.println("Database connection established");
		/*
		 * catch (Exception e) { e.printStackTrace();
		 * System.err.println("Cannot connect to database server"); } finally {
		 * if (conn != null) { try { conn.close();
		 * System.out.println("Database connection terminated"); } catch
		 * (Exception e) { ignore close errors } } }
		 */
		return conn;
	}

	private String buildUrl(String dbType, String host, String port,
			String dbschema) {
		StringBuilder url = new StringBuilder("");// "jdbc:mysql://localhost:3306/syllabus";
		if (DBProperties.MYSQL_TYPE.equals(dbType)) {
			url.append(DBProperties.MYSQL_JDBC_STRING);
			url.append(COLON_SEPARATOR);
			url.append(DOUBLE_SLASH_SEPARATOR);
		}
		url.append(host);
		url.append(COLON_SEPARATOR);
		url.append(port);
		url.append(SINGLE_SLASH_SEPARATOR);
		url.append(dbschema);
		return url.toString();
	}

	private ConnectionDetails getConnectionDetailsFromSystemFile(
			File dbConfigFile) throws XMLReadException {
		ConnectionDetails connectionDetails = new ConnectionDetails();
		Document document = ReadXML.parseXML(dbConfigFile);
		NodeList nList = document.getElementsByTagName(DBProperties.DB_CONFIG);
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				connectionDetails.setDbType(getTagValue(DBProperties.DB_DRIVER,
						eElement));
				connectionDetails.setHost(getTagValue(DBProperties.DB_HOST,
						eElement));
				connectionDetails.setPort(getTagValue(DBProperties.DB_PORT,
						eElement));
				connectionDetails.setDbschema(getTagValue(
						DBProperties.DB_SCHEMA, eElement));
				connectionDetails.setDbUserName(getTagValue(
						DBProperties.USER_NAME, eElement));
				connectionDetails.setDbPassword(getTagValue(
						DBProperties.PASSWORD, eElement));

			}
		}
		return connectionDetails;
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

	public static void main(String[] args) {
		ConnectionManager connectionManager = new ConnectionManager();

		try {
			connectionManager.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ConnectionDetails {
		private String dbType;
		private String dbUserName;
		private String dbPassword;
		private String dbschema;
		private String host;
		private String port;

		/**
		 * @return the dbType
		 */
		public String getDbType() {
			return dbType;
		}

		/**
		 * @param dbType
		 *            the dbType to set
		 */
		public void setDbType(String dbType) {
			this.dbType = dbType;
		}

		/**
		 * @return the dbUserName
		 */
		public String getDbUserName() {
			return dbUserName;
		}

		/**
		 * @param dbUserName
		 *            the dbUserName to set
		 */
		public void setDbUserName(String dbUserName) {
			this.dbUserName = dbUserName;
		}

		/**
		 * @return the dbPassword
		 */
		public String getDbPassword() {
			return dbPassword;
		}

		/**
		 * @param dbPassword
		 *            the dbPassword to set
		 */
		public void setDbPassword(String dbPassword) {
			this.dbPassword = dbPassword;
		}

		/**
		 * @return the dbschema
		 */
		public String getDbschema() {
			return dbschema;
		}

		/**
		 * @param dbschema
		 *            the dbschema to set
		 */
		public void setDbschema(String dbschema) {
			this.dbschema = dbschema;
		}

		/**
		 * @return the host
		 */
		public String getHost() {
			return host;
		}

		/**
		 * @param host
		 *            the host to set
		 */
		public void setHost(String host) {
			this.host = host;
		}

		/**
		 * @return the port
		 */
		public String getPort() {
			return port;
		}

		/**
		 * @param port
		 *            the port to set
		 */
		public void setPort(String port) {
			this.port = port;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ConnectionDetails [dbType=" + dbType + ", dbUserName="
					+ dbUserName + ", dbPassword=" + dbPassword + ", dbschema="
					+ dbschema + ", host=" + host + ", port=" + port + "]";
		}

	}
}
