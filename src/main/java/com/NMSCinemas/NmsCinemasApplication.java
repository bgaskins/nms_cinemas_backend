package com.NMSCinemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.NMSCinemas")
public class NmsCinemasApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NmsCinemasApplication.class, args);
	}

}
