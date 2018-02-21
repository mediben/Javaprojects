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
<<<<<<< HEAD
	static final String URL = "jdbc:mysql://localhost:3306/disciplinedapproach";
	static final String user = "root";
=======
	static final String URL = "";
	static final String user = "";
>>>>>>> b79699206bcef839510ea79eddf6f67aa5ec606a
	static final String password = "";
	static final String driver = "com.mysql.jdbc.Driver";
	
	Connection con = null;
	/*
	 * Call to connect to the DB
	 */
	public Connection getConnection() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot establish conenction to DB ! \n " + e.getMessage());
			System.exit(-1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	  public void closeConnection() {
	    try {
	    	con	.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
}
