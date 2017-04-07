package com.accenture.dab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class BaseDAB {
	static String  host = "jdbc:mysql://localhost:3306/shubham";
	static String db_user = "root";
	static String db_pass = "";

	static final Logger debugLog = Logger.getLogger("errorLogger");
	//static final Logger infoLog = Logger.getLogger("infoLogger");

	protected static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host, db_user, db_pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			debugLog.error("Class not defined",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			debugLog.error("SQL Error",e);
		}

		return con;
	}

	protected static void closeResources(ResultSet rs, PreparedStatement prepstmt, Connection con) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (prepstmt != null) {
				prepstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			debugLog.error("SQL error",e);
		}
	}

	protected static void closeResources(PreparedStatement prepstmt, Connection con) {

		closeResources(null, prepstmt, con);
	}
}



