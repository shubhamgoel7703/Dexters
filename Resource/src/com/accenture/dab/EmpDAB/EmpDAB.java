package com.accenture.dab.EmpDAB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.BaseDAB;


public class EmpDAB extends BaseDAB /*implements IEmpDAB*/ {
	
	
	private static EmpDAB instance =null;
	 
	private EmpDAB() {
	      // Exists only to defeat instantiation.
	   }

	static EmpDAB getInstance() {
	      if(instance == null) {
	    	 // synchronized(instance)
	    	  {
	    		  if(instance==null)
	    		  instance = new EmpDAB();
	    		  }
	      }
	      return instance;
	   }
	
	public static int insertIntoEmployee(EmployeeBean emp) /*throws SQLException, ParseException*/ {

		// use ORM
		String query = "INSERT INTO employee (project,resourceName,gcp,personnelNo,level,resourceType,currentLocation,lockStartDate,billableDate,rollOffDate,joinDate,team,gender,supervisor,visaType,rateType,enterpriseId,contactDetails,DOB,Hometown) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int successPara=0;
		
		Connection connection = getConnection();
		PreparedStatement prepstmt = null;
		try {
			prepstmt = connection.prepareStatement(query);
			
			
			prepstmt.setInt(1, emp.getProject());
			prepstmt.setString(2, emp.getName());
			prepstmt.setBoolean(3, emp.isGcp() );
			prepstmt.setString(4, emp.getPersonnalNo());
			prepstmt.setInt(5,emp.getLevel());
			prepstmt.setInt(6, emp.getResourceType());
			prepstmt.setInt(7,  emp.getCurrentLocation());
			prepstmt.setDate(8, java.sql.Date.valueOf(emp.getLockStartDate().toString()));
			prepstmt.setDate(9, java.sql.Date.valueOf(emp.getBillableDate().toString()));
			prepstmt.setDate(10, java.sql.Date.valueOf(emp.getRollOffDate().toString()));
			prepstmt.setDate(11, java.sql.Date.valueOf(emp.getJoinDate().toString()));
			prepstmt.setInt(12, emp.getTeam());
			prepstmt.setInt(13, emp.getGender());
			prepstmt.setString(14, emp.getSupervisor());
			prepstmt.setInt(15, emp.getVisaType());
			prepstmt.setInt(16, emp.getRateType());
			prepstmt.setString(17, emp.getEnterpriseId());
			prepstmt.setString(18, emp.getContactDetails());
			prepstmt.setDate(19, java.sql.Date.valueOf(emp.getDob().toString()));
			prepstmt.setInt(20, emp.getHomeTown());
			
			successPara = prepstmt.executeUpdate();
			
			System.out.println(successPara);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 closeResources(prepstmt, connection);
		}
		

		
		return successPara;
	}

	public List<EmployeeBean> getEmployeeBeanList() {
		List<EmployeeBean> list_emp = new ArrayList<EmployeeBean>();
		
		String query = "select * from employee";
		// String query ="SHOW COLUMNS FROM "+tableName;
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement prepstmt=null;
		try {
			prepstmt = connection.prepareStatement(query);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				// do somthing
				EmployeeBean emp_bean = new EmployeeBean();
				
				emp_bean.setProject(rs.getInt("project"));  //TODO use column name 
				emp_bean.setName(rs.getString("resourceName"));
				emp_bean.setGcp(rs.getBoolean("gcp"));
				emp_bean.setPersonnalNo(rs.getString("personnelNo"));
				emp_bean.setLevel(rs.getInt("level"));
				emp_bean.setResourceType(rs.getInt("resourceType"));
				emp_bean.setCurrentLocation(rs.getInt("currentLocation"));
				emp_bean.setLockStartDate(rs.getDate("lockStartDate"));
				emp_bean.setBillableDate(rs.getDate("billableDate"));
				emp_bean.setRollOffDate(rs.getDate("rollOffDate"));
				emp_bean.setJoinDate(rs.getDate("joinDate"));
				emp_bean.setTeam(rs.getInt("team"));
				emp_bean.setGender(rs.getInt("gender"));
				emp_bean.setSupervisor(rs.getString("supervisor"));
				emp_bean.setVisaType(rs.getInt("visaType"));
				emp_bean.setRateType(rs.getInt("rateType"));
				emp_bean.setEnterpriseId(rs.getString("enterpriseId"));
				emp_bean.setContactDetails(rs.getString("contactDetails"));
				emp_bean.setDob(rs.getDate("DOB"));
				emp_bean.setHomeTown(rs.getInt("Hometown"));

				System.out.println((rs.getString("project")));
				list_emp.add(emp_bean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {

			closeResources(rs, prepstmt, connection);

		}
		

		
		return list_emp;
	}

	public EmployeeBean getEmpBean(String empId)
	{
		
		String query = "select * from employee where personnelNo=?";
		
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement prepstmt=null;
		try {
			prepstmt = connection.prepareStatement(query);
			prepstmt.setString(1, empId);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				// do somthing
				EmployeeBean emp_bean = new EmployeeBean();
				
				emp_bean.setProject(rs.getInt("project"));  //TODO use column name 
				emp_bean.setName(rs.getString("resourceName"));
				emp_bean.setGcp(rs.getBoolean("gcp"));
				emp_bean.setPersonnalNo(rs.getString("personnelNo"));
				emp_bean.setLevel(rs.getInt("level"));
				emp_bean.setResourceType(rs.getInt("resourceType"));
				emp_bean.setCurrentLocation(rs.getInt("currentLocation"));
				emp_bean.setLockStartDate(rs.getDate("lockStartDate"));
				emp_bean.setBillableDate(rs.getDate("billableDate"));
				emp_bean.setRollOffDate(rs.getDate("rollOffDate"));
				emp_bean.setJoinDate(rs.getDate("joinDate"));
				emp_bean.setTeam(rs.getInt("team"));
				emp_bean.setGender(rs.getInt("gender"));
				emp_bean.setSupervisor(rs.getString("supervisor"));
				emp_bean.setVisaType(rs.getInt("visaType"));
				emp_bean.setRateType(rs.getInt("rateType"));
				emp_bean.setEnterpriseId(rs.getString("enterpriseId"));
				emp_bean.setContactDetails(rs.getString("contactDetails"));
				emp_bean.setDob(rs.getDate("DOB"));
				emp_bean.setHomeTown(rs.getInt("Hometown"));

				System.out.println((rs.getString("project")));
				
				return emp_bean;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {

			closeResources(rs, prepstmt, connection);

		}
		
		//System.out.println("Dao class");
		
		return null;
	}

	public int deleteEmployeeBean(String employeeId)
	{
		String query = "DELETE FROM employee WHERE personnelNo=?";
		Connection con = getConnection();
		int result=0;
		
		PreparedStatement prepstmt=null;
		try {
			prepstmt = con.prepareStatement(query);
			prepstmt.setString(1, employeeId);
			result = prepstmt.executeUpdate();
		
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeResources(prepstmt, con);
		}
		
		return result;
	}
	
	

	public int updateEmployeeBean(EmployeeBean employeeBean) //TODO employeeBean parameter will come and all bean will set
	{
		String query = "update employee set (project=?,resourceName=?,gcp=?,personnelNo=?,level=?,resourceType=?,currentLocation=?,lockStartDate=?,billableDate=?,rollOffDate=?,joinDate=?,team=?,gender=?,supervisor=?,visaType=?,rateType=?,enterpriseId=?,contactDetails=?,DOB=?,Hometown=?) WHERE personnelNo=?;";
		Connection con = getConnection();
		int successPara=0;
		
		PreparedStatement prepstmt=null;
		try {
			prepstmt = con.prepareStatement(query);
			
			prepstmt.setString(21, employeeBean.getPersonnalNo());
			
			prepstmt.setInt(1, employeeBean.getProject());
			prepstmt.setString(2, employeeBean.getName());
			prepstmt.setBoolean(3, employeeBean.isGcp());
			prepstmt.setString(4, employeeBean.getPersonnalNo());
			prepstmt.setInt(5, employeeBean.getLevel());
			prepstmt.setInt(6, employeeBean.getResourceType());
			prepstmt.setInt(7, employeeBean.getCurrentLocation());
			prepstmt.setDate(, x);
			
			successPara = prepstmt.executeUpdate();
		
			System.out.println(successPara);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeResources(prepstmt, con);
		}
		
		return successPara;
	}
	


	

	
	
}
