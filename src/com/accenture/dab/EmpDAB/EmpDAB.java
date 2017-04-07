package com.accenture.dab.EmpDAB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.BaseDAB;

public class EmpDAB extends BaseDAB implements IEmpDAB {

	private static EmpDAB instance = null;
	static final Logger debugLog = Logger.getLogger("errorLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");

	private EmpDAB() {
		// Exists only to defeat instantiation.
	}

	static EmpDAB getInstance() {
		if (instance == null) {
			synchronized (EmpDAB.class) {
				if (instance == null)
					instance = new EmpDAB();
			}
		}
		return instance;
	}

	/*
	 * public static void main(String[] args) {
	 * LOGGER.info("This is a logging statement from log4j"); }
	 */
	public int insertIntoEmployee(EmployeeBean emp) throws SQLException {

		// use ORM
		infoLog.debug("ENTRY");
		String query = "INSERT INTO employee (Project, Name, Gcp, PersonnelNo, Level, ResourceType, Location, LockStartDate, BilliableDate, RollOffDate, JoinDate, Team, Gender, Supervisor,"
				+ ", VisaType, RateType, EnterpriseId, ContactDetails, DateBirth, HomeTown) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int successPara = 0;

		Connection connection = getConnection();
		PreparedStatement prepstmt = null;
		try {
			prepstmt = connection.prepareStatement(query);

			prepstmt.setInt(1, emp.getProject());
			prepstmt.setString(2, emp.getName());
			prepstmt.setBoolean(3, emp.isGcp());
			prepstmt.setString(4, emp.getPersonnalNo());
			prepstmt.setInt(5, emp.getLevel());
			prepstmt.setInt(6, emp.getResourceType());
			prepstmt.setInt(7, emp.getCurrentLocation());
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
			// e.printStackTrace();
			debugLog.error("Insert error for employee", e);
		} finally {
			closeResources(prepstmt, connection);
		}
		infoLog.debug("EXIT");

		return successPara;
	}

	public List<EmployeeBean> getEmployeeBeanList() throws SQLException {

		infoLog.debug("ENTRY");
		List<EmployeeBean> list_emp = new ArrayList<EmployeeBean>();

		String query = "select * from employee";
		// String query ="SHOW COLUMNS FROM "+tableName;
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement prepstmt = null;
		try {
			prepstmt = connection.prepareStatement(query);
			rs = prepstmt.executeQuery();
			while (rs.next()) {
				// do somthing
				EmployeeBean empbean = new EmployeeBean();
				empbean.setProject(rs.getInt("Project"));
				empbean.setName(rs.getString("Name"));
				empbean.setGcp(rs.getBoolean("Gcp"));
				empbean.setPersonnalNo(rs.getString("PersonnelNo"));
				empbean.setLevel(rs.getInt("Level"));
				empbean.setResourceType(rs.getInt("ResourceType"));
				empbean.setCurrentLocation(rs.getInt("Location"));
				empbean.setLockStartDate(rs.getDate("LockStartDate"));
				empbean.setBillableDate(rs.getDate("BillableDate"));
				empbean.setRollOffDate(rs.getDate("RollOffDate"));
				empbean.setJoinDate(rs.getDate("JoinDate"));
				empbean.setTeam(rs.getInt("Team"));
				empbean.setGender(rs.getInt("Gender"));
				empbean.setSupervisor(rs.getString("Supervisor"));
				empbean.setVisaType(rs.getInt("VisaType"));
				empbean.setRateType(rs.getInt("RateType"));
				empbean.setEnterpriseId(rs.getString("EnterpriseId"));
				empbean.setContactDetails(rs.getString("ContactDetails"));
				empbean.setDob(rs.getDate("DateBirth"));
				empbean.setHomeTown(rs.getInt("HomeTown"));
				System.out.println((rs.getInt(1)));
				list_emp.add(empbean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Fetch error for employee data", e);
		}

		finally {

			closeResources(rs, prepstmt, connection);

		}
		infoLog.debug("EXIT");

		return list_emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.accenture.dab.EmpDAB.IEmpDAB#getEmpBean(java.lang.String)
	 */
	public EmployeeBean getEmpBean(String empId) throws SQLException {
		infoLog.debug("ENTRY");
		String query = "Select * from employee where PersonnelNo=?";
		Connection con = getConnection();
		PreparedStatement prepstmt = null;
		ResultSet rs = null;
		EmployeeBean empbean = null;
		try {
			prepstmt = con.prepareStatement(query);
			prepstmt.setString(1, empId);

			rs = prepstmt.executeQuery();
			if (rs != null) { // TODO object construction inside and while loop
								// removal. as only one record is fetched
				empbean = new EmployeeBean();
				empbean.setProject(rs.getInt("Project"));
				empbean.setName(rs.getString("Name"));
				empbean.setGcp(rs.getBoolean("Gcp"));
				empbean.setPersonnalNo(rs.getString("PersonnelNo"));
				empbean.setLevel(rs.getInt("Level"));
				empbean.setResourceType(rs.getInt("ResourceType"));
				empbean.setCurrentLocation(rs.getInt("Location"));
				empbean.setLockStartDate(rs.getDate("LockStartDate"));
				empbean.setBillableDate(rs.getDate("BillableDate"));
				empbean.setRollOffDate(rs.getDate("RollOffDate"));
				empbean.setJoinDate(rs.getDate("JoinDate"));
				empbean.setTeam(rs.getInt("Team"));
				empbean.setGender(rs.getInt("Gender"));
				empbean.setSupervisor(rs.getString("Supervisor"));
				empbean.setVisaType(rs.getInt("VisaType"));
				empbean.setRateType(rs.getInt("RateType"));
				empbean.setEnterpriseId(rs.getString("EnterpriseId"));
				empbean.setContactDetails(rs.getString("ContactDetails"));
				empbean.setDob(rs.getDate("DateBirth"));
				empbean.setHomeTown(rs.getInt("HomeTown"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Fetch error for employee data", e);
		} finally {
			closeResources(prepstmt, con);
		}
		infoLog.debug("EXIT");

		return empbean;
	}

	public int stateUpdateEmployeeBean(EmployeeBean empBean) throws SQLException// TODO
																				// should
																				// not
																				// bbe
																				// deletign
																				// the
																				// record.
																				// isActive
																				// flag
	{
		infoLog.debug("ENTRY");
		String query = "UPDATE employee set isActive=? WHERE personnelNo=?;";
		Connection con = getConnection();
		int result = 0;

		PreparedStatement prepstmt = null;
		try {
			prepstmt = con.prepareStatement(query);

			prepstmt.setString(2, empBean.getPersonnalNo());
			prepstmt.setBoolean(1, empBean.isActive());

			result = prepstmt.executeUpdate();

			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("State update error for employee data", e);
		} finally {
			closeResources(prepstmt, con);
		}
		infoLog.debug("EXIT");

		return result;
	}

	public int updateEmployeeBean(EmployeeBean empBean) throws SQLException// TODO
																			// employeeBean
																			// parameter
																			// will
																			// come
																			// and
																			// all
																			// bean
																			// will
																			// set
	{
		infoLog.debug("ENTRY");
		String query = "UPDATE employee set (Project=?, Name=?, Gcp=?, PersonnelNo=?, Level=?, ResourceType=?, Location=?, LockStartDate=?, BilliableDate=?, RollOffDate=?, JoinDate=?, Team=?, Gender=?, Supervisor=?,VisaType=?, RateType=?, EnterpriseId=?, ContactDetails=?, DateBirth=?, HomeTown=?) WHERE PersonnelNo=?";
		Connection con = getConnection();
		int successPara = 0;

		PreparedStatement prepstmt = null;
		try {
			prepstmt = con.prepareStatement(query);
			prepstmt.setString(21, empBean.getPersonnalNo());

			prepstmt.setInt(1, empBean.getProject());
			prepstmt.setString(2, empBean.getName());
			prepstmt.setBoolean(3, empBean.isGcp());
			prepstmt.setString(4, empBean.getPersonnalNo());
			prepstmt.setInt(5, empBean.getLevel());
			prepstmt.setInt(6, empBean.getResourceType());
			prepstmt.setInt(7, empBean.getCurrentLocation());
			prepstmt.setDate(8, java.sql.Date.valueOf(empBean.getLockStartDate().toString()));
			prepstmt.setDate(9, java.sql.Date.valueOf(empBean.getBillableDate().toString()));
			prepstmt.setDate(10, java.sql.Date.valueOf(empBean.getRollOffDate().toString()));
			prepstmt.setDate(11, java.sql.Date.valueOf(empBean.getJoinDate().toString()));
			prepstmt.setInt(12, empBean.getTeam());
			prepstmt.setInt(13, empBean.getGender());
			prepstmt.setString(14, empBean.getSupervisor());
			prepstmt.setInt(15, empBean.getVisaType());
			prepstmt.setInt(16, empBean.getRateType());
			prepstmt.setString(17, empBean.getEnterpriseId());
			prepstmt.setString(18, empBean.getContactDetails());
			prepstmt.setDate(19, java.sql.Date.valueOf(empBean.getDob().toString()));
			prepstmt.setInt(20, empBean.getHomeTown());

			successPara = prepstmt.executeUpdate();

			System.out.println(successPara);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			debugLog.error("Update error for employee data", e);
		} finally {
			closeResources(prepstmt, con);
		}
		infoLog.debug("EXIT");

		return successPara;
	}

}
