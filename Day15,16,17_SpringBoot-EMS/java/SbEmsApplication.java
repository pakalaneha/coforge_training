package com.coforge.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// starting point of the application

//annotation for main class - combination of 3 annotations
// @Configuration(to create object/configure bean object), 
//@EnableAutoConfiguration (automatically configures the application)
//@ComponentScan (to scan base package) -> controller, service, restcontroller,repository
@SpringBootApplication 
public class SbEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEmsApplication.class, args);
	}

}
