package com.revature.hydra.screening.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.SoftSkillViolation;
import com.revature.beans.ViolationType;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.service.ScreeningCompositionService;

@RestController
@CrossOrigin
public class ScreeningController {
	
	private static final Logger log = Logger.getLogger(ScreeningController.class);
	
	@Autowired
	private ScreeningRepository screeningRepository;

	private ScreeningCompositionService scs;

	@Autowired
	public void setScreeningCompositionService(ScreeningCompositionService scs) {
		this.scs = scs;
	}

	/*
	 * Screening controller endpoints
	 */
	
	/*
	 * List of softSkillViolations by ScreeningID
	 */
	@RequestMapping(value="/screening/violation/{screeningID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>>  softSkillViolationsByScreeningID(@PathVariable(value="screeningID") Integer screeningID){
		log.info("List of softSkillViolations by ScreeningID/" + screeningID);
		List<SoftSkillViolation> ssv = scs.softSkillViolationsByScreeningId(screeningID);
		return new ResponseEntity<List<SoftSkillViolation>>(ssv, HttpStatus.OK);
	}
	
	/*
	 * List of Violation
	 */
	@RequestMapping(value="/violation/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>>getViolationTypes(){
		List<ViolationType> vios = scs.violationTypes();
		return new ResponseEntity<List<ViolationType>>(vios, HttpStatus.OK);
	}
	
	/*
	 * Delete soft skill violation
	 */
	@RequestMapping(value="/violation/delete/{violationID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteViolation (@PathVariable(value="violationID") Integer violationID) {
		scs.deleteViolation(violationID);
		return new ResponseEntity<String>("Delete Completed", HttpStatus.OK);
	}
	
	
	/*
	 * Update aboutMeCommentary by ScreeningID
	 */
	@RequestMapping(value="/screening/introcomment", method=RequestMethod.POST)
	public ResponseEntity<String> updateAboutMeCommentary (@RequestParam String introComment, 
			@RequestParam Integer screeningId){
		log.info("AboutMeCommentary: " + introComment);
		log.info("screeningId: "+ screeningId);
		scs.updateAboutMeCommentary(introComment, screeningId);
		return new ResponseEntity<String>("Update introComment Completed", HttpStatus.OK);
	}
	
	/*
	 * Store soft skill violation and Return softSkillViolationID
	 * @param - array [violationTypeID] / String softSkillComment / Date violationTime"
	 */
	@RequestMapping(value = "/violation/flag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createSoftSkillViolationAndReturnSoftSkillViolationID () {
		/* @Param */
		Integer[] violationIds = {1,2};		//array [violationTypeID]
		String softSkillComment = "";
		Date violationTime = new Date();
		/* working on */
		
		
		
		return null;
	}
	
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
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreeningAndReturnQuestionsFromTags(
			@RequestParam(name="traineeId") Integer traineeId,
			@RequestParam(name="beginTime") Date date,
			@RequestParam(name="trainerId") Integer trainerId,
			@RequestParam(name="skillTypeId") Integer skillTypeId){
		
		SimpleScreening screening = new SimpleScreening(trainerId, traineeId,
				skillTypeId, 0.0, "", "",
				"", date, null, false,
				"pending");
		screeningRepository.save(screening);
		return new ResponseEntity<>(screening.getScreeningId(),HttpStatus.OK);
	}
	
	/*
	 * Store the general comment in the Screening entity
	 */
	@RequestMapping(value = "/screening/generalcomment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> storeGeneralComment(@RequestParam(name="screeningId") Integer screeningId, 
			@RequestParam(name="comment") String comment){
		log.debug("screeningId : "+ screeningId);
		log.debug("comment : " + comment);
		scs.updateGeneralCommentary(comment, screeningId);
		return new ResponseEntity<String>( "Update General Comment Success!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/screening/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
