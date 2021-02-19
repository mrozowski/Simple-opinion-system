package com.mrozowski.OpinionSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})  //I run this only during first testing when I still didn't have connected mysql database
@SpringBootApplication
public class OpinionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinionSystemApplication.class, args);
	}

}
