package org.springframework.xml.petclinic;

import org.springframework.samples.petclinic.stsdemo.WelcomeMessageProvider;

public class SimpleWelcomeMessageProvider implements WelcomeMessageProvider {

	private String message;

	public SimpleWelcomeMessageProvider(String message) {
		this.message = message;
	}

	@Override
	public String get() {
		return message;
	}
	
}
