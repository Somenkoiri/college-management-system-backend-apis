package com.college.ms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemApplication.class, args);
		System.out.println("Program Working.....");
	}
	
	  @Bean
	  public ModelMapper modelMapper() {
		  
		  return new ModelMapper();
	    }

}
