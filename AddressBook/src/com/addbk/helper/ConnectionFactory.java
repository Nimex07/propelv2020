package com.addbk.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	static Connection connection = null;

	public static Connection getConnection() throws Exception {

		try {
			// calling the method loadPropoperitesFile() to get the details from
			// jdbc.properties
			Properties prop = loadPropertiesFile();

			// storing properties into variables
			String driverClass = prop.getProperty("ORACLEJDBC.JDBC_DRIVER");
			String url = prop.getProperty("ORACLEJDBC.DB_URL");
			String username = prop.getProperty("ORACLEJDBC.USER");
			String password = prop.getProperty("ORACLEJDBC.PASS");

			// register jdbc driver
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			throw new RuntimeException("Error Connecting to the database ", e);
		}

	}

	private static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("jdbc.properties"));

		return prop;
	}

	public static void main(String[] args) {

		try {

			connection = ConnectionFactory.getConnection();
			System.out.println(connection);
			System.out.println("connected to database");

		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
