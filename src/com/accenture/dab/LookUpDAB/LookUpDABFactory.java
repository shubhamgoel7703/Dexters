package com.accenture.dab.LookUpDAB;

public class LookUpDABFactory {

	LookUpDAB iLookUpDAB = null;

	private LookUpDABFactory() {
		// Exists only to defeat instantiation.
	}

	public LookUpDAB objCreator() {

		iLookUpDAB = LookUpDAB.getInstance();

		return iLookUpDAB;
	}

}
