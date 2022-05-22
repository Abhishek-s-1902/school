package com.demo.edu.school.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SchoolApplication 
{
	
	
    public static void main( String[] args )
    {
    	SpringApplication.run(SchoolApplication.class, args);
    	System.out.println("returning from main");
    }
}
