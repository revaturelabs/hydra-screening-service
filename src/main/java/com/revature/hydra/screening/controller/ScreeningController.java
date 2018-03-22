package com.revature.hydra.screening.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleTrainee;
import com.revature.beans.ViolationType;
import com.revature.hydra.screening.service.ScreeningCompositionService;

@RestController
@CrossOrigin
public class ScreeningController {

	private ScreeningCompositionService scs;

	@Autowired
	public void setScreeningCompositionService(ScreeningCompositionService scs) {
		this.scs = scs;
	}

	/*
	 * Screening controller endpoints
	 */
	
	/**
	 * Test to get one trainee
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/single", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleTrainee> getSingleTrainee(){
		SimpleTrainee trainee = scs.getOneTrainee(1);
		return new ResponseEntity<SimpleTrainee>(trainee, HttpStatus.OK);
	}
	
	/**
	 * Starts a screening by putting the screening into the database and returning 
	 * 
	 * 
	 */
	@RequestMapping(value = "/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreeningAndReturnQuestionsFromTags(
			@RequestParam(name="tagID") Integer[] tagId,
			@RequestParam(name="traineeId") Integer traineeId,
			@RequestParam(name="beginTime") Date date,
			@RequestParam(name="violationTypeId") ViolationType[] violationTypeId,
			@RequestParam(name="aboutMeComment") String aboutMeComment){
		
		return new ResponseEntity<>(new Integer(1),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generalcomment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void storeGeneralComment(@RequestParam(name="screeningId") Integer screeningId){
		
	}
	
	@RequestMapping(value = "/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void endScreening(
			@RequestParam(name="status") Boolean status,
			@RequestParam(name="softSkillsVerdict") Boolean softSkillsVerdict,
			@RequestParam(name="violationTypeId") Integer [] violationTypeIds,
			@RequestParam(name="softSkillComment") String softSkillComment,
			@RequestParam(name="endTime") Date endTime,
			@RequestParam(name="screeningId") Integer screeningId,
			@RequestParam(name = "compositeScore") Integer compositeScore
			) {
		
	}
}
