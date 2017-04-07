package com.accenture.dab.EmpDAB;

public class EmpDABFactory {

	EmpDAB iEmpDAB = null;

	private EmpDABFactory() {
		// Exists only to defeat instantiation.
	}

	public EmpDAB objCreator() {

		iEmpDAB = EmpDAB.getInstance();

		return iEmpDAB;
	}

}
