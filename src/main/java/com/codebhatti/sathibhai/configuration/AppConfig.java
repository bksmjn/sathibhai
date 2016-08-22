package com.codebhatti.sathibhai.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="com.codebhatti.sathibhai.*")
@EnableWebMvc
public class AppConfig {

	public AppConfig(){
		System.out.println("INSIDE APP CONFIG");
	}
}
