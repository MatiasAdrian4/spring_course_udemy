package com.luv2code.springdemo;

public class GymCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public GymCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do 4 squat series";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
