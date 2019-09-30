package org.springframework.samples.petclinic.stsdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty("petclinic.welcome.greeting")
@Component
public class PropertyBasedWelcomeMessageProvider implements WelcomeMessageProvider {
	
	@Value("${petclinic.welcome.greeting}")
	String welcomeMessage;

	public String get() {
		return welcomeMessage;
	}
}
