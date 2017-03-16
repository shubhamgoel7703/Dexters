package com.accenture.dab.LookUpDAB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.dab.BaseDAB;

public class LookUpDAB extends BaseDAB implements ILookUpDAB
{
	
	private static LookUpDAB instance =null;
	 
	private LookUpDAB() {
	      // Exists only to defeat instantiation.
	   }

	static LookUpDAB getInstance() {
	      if(instance == null) {
	    	//  synchronized(instance)
	    	  {
	    		  if(instance==null)
	    		  instance = new LookUpDAB();
	    	  }
	      }
	      return instance;
	   }
	
	public int insertIntoLookUp(String tableName,String text) throws SQLException{
		String countQuery = "SELECT COUNT(*) as count FROM "+ tableName;
		
		Connection con = getConnection();
		PreparedStatement prepstmt = con.prepareStatement(countQuery);

		ResultSet rs = prepstmt.executeQuery();
		int count=0;
		while (rs.next()) {
			count = rs.getInt("count");
		}
		System.out.println(count);
		
		countQuery = "INSERT INTO "+ tableName +"(id,text) VALUES (?,?)";
		
		prepstmt = con.prepareStatement(countQuery);
		
		prepstmt.setInt(1, count+1);
		prepstmt.setString(2, text);
		
		return prepstmt.executeUpdate();
		
	}
	
	public boolean updateLookUpBean(String tableName,String text) throws SQLException {
		String query = "UPDATE" + tableName
				+ "column1 = value1, column2 = value2...., columnN = valueN WHERE [condition];";
		Connection con = getConnection();
		PreparedStatement prepstmt = con.prepareStatement(query);

		ResultSet rs = prepstmt.executeQuery();
		while (rs.next()) {
			// do somthing
		}
		return false;
	}
	
	public boolean deleteLookUpBean(String tableName,String text) throws SQLException {
		String query = "DELETE FROM " + tableName + "table_name WHERE [condition];";
		Connection con = getConnection();
		PreparedStatement prepstmt = con.prepareStatement(query);

		ResultSet rs = prepstmt.executeQuery();
		while (rs.next()) {
			// do somthing
		}
		return false;
	}
	
	public int retriveFromLookUp(String tableName,String text){
		
		return 0;
	}
	
	
}