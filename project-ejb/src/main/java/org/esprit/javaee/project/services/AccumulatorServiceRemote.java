package org.esprit.javaee.project.services;

import javax.ejb.Remote;

@Remote
public interface AccumulatorServiceRemote {
	
	int add(int dx);

}
