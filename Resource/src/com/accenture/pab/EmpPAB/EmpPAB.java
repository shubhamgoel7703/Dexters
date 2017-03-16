package com.accenture.pab.EmpPAB;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.EmpDAB.EmpDABFactory;

public class EmpPAB {

	private static EmpPAB instance =null;
	 
	   private EmpPAB() {
	      // Exists only to defeat instantiation.
	   }

	public static EmpPAB getInstance() {
	      if(instance == null) {
	    	  //synchronized(instance)
	    	  	{
	    		  if(instance==null)
	    		  instance = new EmpPAB();
	    		}
	      }
	      return instance;
	   }
	
	
	public EmployeeBean getEmpData()
	{
		EmpDABFactory empDABFactory = EmpDABFactory.getInstance();
		EmployeeBean emp= new EmployeeBean();
		System.out.println("get Emp  data function");
		
		return empDABFactory.ObjCreator().getEmpBean("");
		
	}
	
}
