package com.revature.hydra.screening.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleTrainee;

@Service	
public class ScreeningCompositionMessagingService {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	private static final String SINGLE_TRAINEE_ROUTING_KEY = "JyoH3uRmktGn9MnW";
	
	/**
	 * RabbitMQ Exchange Name
	 * 
	 */
	private static final String RABBIT_REPO_EXCHANGE = "revature.hydra.repos";
	
	public SimpleTrainee sendSingleTraineeRequest(Integer traineeId) {
		JsonObject traineeRequest = new JsonObject();
		
		traineeRequest.addProperty("methodName", "findOne");
		traineeRequest.addProperty("traineeId", traineeId);
		
		SimpleTrainee st =  (SimpleTrainee)rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE,
				SINGLE_TRAINEE_ROUTING_KEY,
				traineeRequest.toString());
		return st;
	}
	
}

