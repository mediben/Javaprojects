package mbt.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	/*
	 *  @URL = your database server
	 *  @user = your username to access DB
	 *  @password = your password to access DB
	 *  @driver = if you are not using Mysql please update the driver with the adquent driver
	 */
	static final String URL = "";
	static final String user = "";
	static final String password = "";
	static final String driver = "com.mysql.jdbc.Driver";
	
	/*
	 * Call to connect to the DB
	 */
	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot establish conenction to DB ! \n " + e.getMessage());
			System.exit(-1);
		}
		return con;
	}
}
