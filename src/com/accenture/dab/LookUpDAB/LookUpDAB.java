package com.accenture.dab.LookUpDAB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.accenture.bean.LookUpBean;
import com.accenture.dab.BaseDAB;

public class LookUpDAB extends BaseDAB implements ILookUpDAB {
	private static LookUpDAB instance = null;
	static final Logger debugLog = Logger.getLogger("errorLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");

	private LookUpDAB() {
		// Exists only to defeat instantiation.
	}

	static LookUpDAB getInstance() {
		if (instance == null) {
			synchronized (LookUpDAB.class) {
				if (instance == null)
					instance = new LookUpDAB();
			}
		}
		return instance;
	}

	public int insertIntoLookUp(String tableName, String text) throws SQLException {
		infoLog.debug("ENTRY");
		String countQuery = "INSERT INTO ? (text) VALUES (?);";

		Connection con = getConnection();
		PreparedStatement prepstmt;
		int result = 0;
		try {
			prepstmt = con.prepareStatement(countQuery);

			prepstmt.setString(1, tableName);
			prepstmt.setString(2, text);

			result = prepstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Insert error for Lookup data", e);
		}
		infoLog.debug("EXIT");

		return result;

	}

	public int updateLookUpBean(String tableName, LookUpBean lookBean) throws SQLException {
		infoLog.debug("ENTRY");
		String query = "UPDATE ? text = ? WHERE id=?;";
		Connection con = getConnection();
		PreparedStatement prepstmt;
		int result = 0;
		try {
			prepstmt = con.prepareStatement(query);

			prepstmt.setString(1, tableName);

			prepstmt.setString(2, lookBean.getText());
			prepstmt.setInt(3, lookBean.getId());
			result = prepstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Update error for Lookup data", e);
		}
		infoLog.debug("EXIT");
		return result;
	}

	public boolean deleteLookUpBean(String tableName, int id) throws SQLException {
		infoLog.debug("ENTRY");
		String query = "DELETE FROM ? WHERE id=?;";
		Connection con = getConnection();
		PreparedStatement prepstmt;
		boolean result = false;
		try {
			prepstmt = con.prepareStatement(query);
			prepstmt.setString(1, tableName);
			prepstmt.setInt(2, id);
			result = prepstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Delete error for Lookup data", e);
		}
		infoLog.debug("EXIT");

		return result;
	}

	public LookUpBean retriveFromLookUp(String tableName) throws SQLException {
		infoLog.debug("ENTRY");
		String query = "Select * FROM ?;";
		Connection con = getConnection();
		PreparedStatement prepstmt;
		LookUpBean look_bean = null;
		try {
			prepstmt = con.prepareStatement(query);

			prepstmt.setString(1, tableName);
			ResultSet rs = prepstmt.executeQuery();
			while (rs.next()) {
				look_bean = new LookUpBean();
				look_bean.setId(rs.getInt("id"));
				look_bean.setText(rs.getString("text"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Fetch error for Lookup data", e);
		}
		infoLog.debug("EXIT");

		return look_bean;
	}

}