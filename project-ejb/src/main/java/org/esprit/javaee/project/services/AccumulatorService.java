package org.esprit.javaee.project.services;

import javax.ejb.Stateful;

@Stateful
public class AccumulatorService implements AccumulatorServiceRemote, AccumulatorServiceLocal {

	private int x = 0;
	
    public AccumulatorService() {
    }

	public int add(int dx) {
		x = x + dx;
		return x;
	}

}
