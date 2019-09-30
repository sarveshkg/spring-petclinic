package org.springframework.samples.petclinic.stsdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("petclinic.welcome")
public class WelcomeProperties {

	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
}
