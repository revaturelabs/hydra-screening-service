package com.revature.hydra.screening.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleTrainee;
import com.revature.hydra.screening.data.ScreeningRepository;

@Service
public class ScreeningCompositionService {


	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private ScreeningCompositionMessagingService scms; 
	
	/*
	 * Test class using trainee service
	 * 
	 * @param 
	 * @return SimpleTrainee
	 * 
	 */
	public SimpleTrainee getOneTrainee(Integer id) {
		SimpleTrainee st =scms.sendSingleTraineeRequest(id);

		return st;
	}
	
}
