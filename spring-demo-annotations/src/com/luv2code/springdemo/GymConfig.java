package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GymConfig {
	
	@Bean
	public FortuneService adviceFortuneService() {
		return new AdviceFortuneService();
	}
	
	@Bean
	public Coach gymCoach() {
		return new GymCoach(adviceFortuneService());
	}

}
