package com.luv2code.springdemo;

public class AdviceFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Don't skip leg day";
	}

}
