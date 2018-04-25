package com.kafka.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.kafka.dto.Message;

@Service
public class MessageService {

	public List<Message> createAndReturnMessage() {
		Integer randInt = getRandomNumberInRange(1, 2000);
		List<Message> msgs = new ArrayList<Message>(randInt);
		
		for(int i=0;i<randInt;i++) {
			Message msg = new Message(String.valueOf(i), new Date(), getRandomDouble(1, 2000),getRandomDouble(-100, 100));
			msgs.add(msg);
		}
		return msgs;
		
		
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public Double getRandomDouble(int rangeMin,int rangeMax) {
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return randomValue;
	}
}
