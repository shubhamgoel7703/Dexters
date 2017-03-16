package com.accenture.pab.LookUpPAB;

import java.sql.SQLException;

import com.accenture.bean.EmployeeBean;
import com.accenture.bean.LookUpBean;
import com.accenture.dab.EmpDAB.EmpDABFactory;
import com.accenture.dab.LookUpDAB.LookUpDABFactory;
import com.accenture.pab.EmpPAB.EmpPAB;

public class LookUpPAB {
	
	private static LookUpPAB instance =null;
	 
	   private LookUpPAB() {
	      // Exists only to defeat instantiation.
	   }

	public static LookUpPAB getInstance() {
	      if(instance == null) {
	    //	  synchronized(instance)
	    	  	{
	    		  if(instance==null)
	    		  instance = new LookUpPAB();
	    		  }
	      }
	      return instance;
	   }
	
	
	public int insertIntoLookUp() throws SQLException
	{
		LookUpDABFactory lookUpDABFactory = LookUpDABFactory.getInstance();
		
		return lookUpDABFactory.ObjCreator().insertIntoLookUp("gender","male");
	}

}
