package org.springframework.xml.petclinic;

import org.springframework.boot.CommandLineRunner;

public class LegacyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Old stuff is running too!");
	}

}
