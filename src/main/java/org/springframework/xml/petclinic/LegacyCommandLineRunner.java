package org.springframework.xml.petclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.samples.petclinic.stsdemo.WelcomeMessageProvider;

public class LegacyCommandLineRunner implements CommandLineRunner {

	private WelcomeMessageProvider welcomeMessageProvider = () -> "no welcome message provider is configured";

	public LegacyCommandLineRunner() {
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Legacy commandline runner starting");
		System.out.println(welcomeMessageProvider.get());
	}

	public WelcomeMessageProvider getWelcomeMessageProvider() {
		return welcomeMessageProvider;
	}

	public void setWelcomeMessageProvider(WelcomeMessageProvider welcomeMessageProv) {
		this.welcomeMessageProvider = welcomeMessageProv;
	}

}
