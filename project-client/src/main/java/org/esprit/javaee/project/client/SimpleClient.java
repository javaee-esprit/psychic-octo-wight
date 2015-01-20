package org.esprit.javaee.project.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.esprit.javaee.project.services.CalculatorServiceRemote;

public class SimpleClient {
	
	
	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext(); 
		Object  obj = ctx.lookup("/project-ejb/CalculatorService!org.esprit.javaee.project.services.CalculatorServiceRemote");
		
		CalculatorServiceRemote calculatorService = (CalculatorServiceRemote) obj;
		int  z = calculatorService.sum(1, 2);
		System.out.println(z);
	}

}
