package com.accenture.dab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAB {
	static String  host = "jdbc:mysql://localhost:3306/shubham";
	static String db_user = "root";
	static String db_pass = "";

	protected static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host, db_user, db_pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}

	protected static void closeResources(PreparedStatement prepstmt, Connection con) {

		closeResources(null, prepstmt, con);
	}
}

