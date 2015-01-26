package org.esprit.javaee.project.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TranslatorService implements TranslatorServiceRemote {

	@EJB 
	private Dictionnary dictionnary;

	public TranslatorService() {
	}

	public String translate(String french) {
		String english = dictionnary.getTranslations().get(french);
		return english == null ? "not found" : english;
	}

}
