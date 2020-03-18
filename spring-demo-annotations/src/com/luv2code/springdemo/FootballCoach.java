package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Train like Adama Traore";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
