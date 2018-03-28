package com.revature.hydra.screening.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SoftSkillViolation;
import com.revature.beans.ViolationType;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.data.SoftSkillViolationRepository;
import com.revature.hydra.screening.service.ScreeningCompositionService;
import com.revature.hydra.screening.wrapper.CommentaryWrapper;
import com.revature.hydra.screening.wrapper.ViolationFlagWrapper;

@RestController
@CrossOrigin
public class ScreeningController {
	
	private static final Logger log = Logger.getLogger(ScreeningController.class);
	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private SoftSkillViolationRepository softSkillViolationRepository;

	private ScreeningCompositionService scs;

	@Autowired
	public void setScreeningCompositionService(ScreeningCompositionService scs) {
		this.scs = scs;
	}

	/*
	 * Screening controller endpoints
	 */
	
	/**
	 * 
	 * List of softSkillViolations by ScreeningID
	 * 
	 * @param screeningID
	 * @return
	 */
	@RequestMapping(value="/screening/violation/{screeningID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>>  softSkillViolationsByScreeningID(@PathVariable(value="screeningID") Integer screeningID){
		log.info("List of softSkillViolations by ScreeningID/" + screeningID);
		List<SoftSkillViolation> ssv = scs.softSkillViolationsByScreeningId(screeningID);
		return new ResponseEntity<List<SoftSkillViolation>>(ssv, HttpStatus.OK);
	}
	
	/**
	 * List of Violation
	 * 
	 * @return
	 */
	@RequestMapping(value="/violation/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>>getViolationTypes(){
		List<ViolationType> vios = scs.violationTypes();
		return new ResponseEntity<List<ViolationType>>(vios, HttpStatus.OK);
	}
	
	/**
	 * Delete soft skill violation
	 * 
	 * @param violationID
	 * @return
	 */
	@RequestMapping(value="/violation/delete/{softSkillViolationID}", method= RequestMethod.GET)
	public ResponseEntity<String> deleteSoftSkillViolation (@PathVariable(value="softSkillViolationID") Integer softSkillViolationID) {
		scs.deleteSoftSkillViolation(softSkillViolationID);
		return new ResponseEntity<String>("Delete Completed", HttpStatus.OK);
	}

	/**
	 * Update AboutMeCommentary of a screening
	 * 
	 * @param simpleScreening
	 * @return
	 */
	@RequestMapping(value="/screening/introcomment", method=RequestMethod.POST)
	public ResponseEntity<String> updateAboutMeCommentary (@RequestBody CommentaryWrapper comment){
		scs.updateAboutMeCommentary(
				comment.comment, 
				comment.screeningId);
		return new ResponseEntity<String>("Update introComment Completed", HttpStatus.OK); 
	}
	
	/*
	 * Store soft skill violation and Return softSkillViolationID
	 * @param - array [violationTypeID] / String softSkillComment / Date violationTime"
	 */
	@RequestMapping(value = "/violation/flag", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createSoftSkillViolationAndReturnSoftSkillViolationID (@RequestBody ViolationFlagWrapper violationFlag) {
		SimpleScreening ss = screeningRepository.findOne(violationFlag.screeningId);
		for(Integer violationId : violationFlag.violationTypeId) {
			SoftSkillViolation ssv = new SoftSkillViolation(ss, violationId, violationFlag.softSkillComment, violationFlag.violationTime);
			softSkillViolationRepository.save(ssv);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Starts a screening by putting the screening into the database and returning 
	 * 
	 * 
	 */
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(
			@RequestBody SimpleScreening simpleScreening){
		
		SimpleScreening screening = simpleScreening;
		SimpleScreening i = screeningRepository.save(screening);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}
	
	/*
	 * Store the general comment in the Screening entity
	 */
	@RequestMapping(value = "/screening/generalcomment", method = RequestMethod.POST)
	public ResponseEntity<String> storeGeneralComment(@RequestBody CommentaryWrapper comment){
		scs.updateGeneralCommentary(comment.comment, comment.screeningId);
		return new ResponseEntity<String>( "Update General Comment Success!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/screening/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> endScreening(@RequestBody SimpleScreening simpleScreening) {
		screeningRepository.updateScreeningInformationByScreeningId(
				simpleScreening.getStatus(), 
				simpleScreening.getSoftSkillsVerdict(), 
				simpleScreening.getSoftSkillCommentary(),
				simpleScreening.getEndDateTime(),
				simpleScreening.getCompositeScore(),
				simpleScreening.getScreeningId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
