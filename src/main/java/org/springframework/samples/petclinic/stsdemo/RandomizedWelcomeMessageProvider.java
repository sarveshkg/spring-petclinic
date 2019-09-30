package org.springframework.samples.petclinic.stsdemo;

import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"s1p", "experimental"})
@Component
public class RandomizedWelcomeMessageProvider implements WelcomeMessageProvider {

	private Random random = new Random();
	
	private String[] messages = {
			"Welcome to the STS PetClinic Demo",
			"Spring One Platform Welcomes You",
			"Spring Tool Suite Demo"
	};

	@Override
	public String get() {
		return messages[random.nextInt(messages.length)];
	}
	
}
