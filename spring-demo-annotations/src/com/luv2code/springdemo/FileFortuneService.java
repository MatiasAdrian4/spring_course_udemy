package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	@Value("${foo.title}")
	private String title;

	private Random myRandom = new Random();
	
	private List<String> fortunes;
	
	@PostConstruct
	public void setupMyData() {
		System.out.println("Inside " + title + " constructor.");
		
		File theFile = new File("src/fortune-data.txt");
		
		fortunes = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				System.out.println(tempLine);
				fortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.size());
		return fortunes.get(index);
	}

}
