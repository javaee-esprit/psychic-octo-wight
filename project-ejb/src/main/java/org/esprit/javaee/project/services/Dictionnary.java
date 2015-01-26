package org.esprit.javaee.project.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@LocalBean
public class Dictionnary{
	
	
	private Map<String, String> translations;

	public Dictionnary() {
	}
	
	@PostConstruct
	public void init(){
		translations = new HashMap<>();
		translations.put("bonjour", "good morning");
		translations.put("attendre", "wait");
		translations.put("rire", "laugh");
	}
	
	public String translate(String french) {
		String english = translations.get(french);
		return english==null?"not found":english;
	}

	public Map<String, String> getTranslations() {
		return translations;
	}
}
