package org.esprit.javaee.project.services;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(CalculatorServiceRemote.class)
@Local(CalculatorServiceLocal.class)
public class CalculatorService implements  CalculatorServiceRemote,CalculatorServiceLocal{

	public int sum(int x, int y) {
		return x+y;
	}


}
