package com.luv2code.springboot.thymeleafdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafdemoApplication {
	
	public static final Logger logger = LoggerFactory.getLogger("com.mkyong");
	
	
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
		
		//Set this before the logger start.
        System.setProperty("log.name", "abcdefg");
        	     
	}
}

