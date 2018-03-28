package com.revature.hydra.screening.controller;

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

/**
 * The controller for incoming REST requests to the Screening service.
 * 
 * @author sungkwon, gin, echamp, batem, ahmed
 *
 */
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
	 * Returns a list of softSkillViolation objects by ScreeningID
	 * 
	 * @param screeningID - the unique id of a Screening
	 * @return List of ViolationType objects
	 */
	@RequestMapping(value="/screening/violation/{screeningID}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SoftSkillViolation>>  softSkillViolationsByScreeningID(@PathVariable(value="screeningID") Integer screeningID){
		log.info("List of softSkillViolations by ScreeningID/" + screeningID);
		List<SoftSkillViolation> ssv = scs.softSkillViolationsByScreeningId(screeningID);
		return new ResponseEntity<List<SoftSkillViolation>>(ssv, HttpStatus.OK);
	}
	
	/**
	 * Returns a list of ViolationType objects representing all held in the database
	 * 
	 * @return List of ViolationType objects
	 */
	@RequestMapping(value="/violation/all", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ViolationType>>getViolationTypes(){
		List<ViolationType> vios = scs.violationTypes();
		return new ResponseEntity<List<ViolationType>>(vios, HttpStatus.OK);
	}
	
	/**
	 * Delete a soft skill violation by its unique id
	 * 
	 * @param softSkillViolationID - the unique id of the SoftSkillViolation object to be deleted
	 * @return A ResponseEntity that contains a delete completed message and an HttpStatus of OK.
	 */
	@RequestMapping(value="/violation/delete/{softSkillViolationID}", method= RequestMethod.GET)
	public ResponseEntity<String> deleteSoftSkillViolation (@PathVariable(value="softSkillViolationID") Integer softSkillViolationID) {
		scs.deleteSoftSkillViolation(softSkillViolationID);
		return new ResponseEntity<String>("Delete Completed", HttpStatus.OK);
	}

	/**
	 * Update the AboutMeCommentary variable of a Screening object
	 * 
	 * @param comment - CommentaryWrapper object that represents a comment and screeningID
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value="/screening/introcomment", method=RequestMethod.POST)
	public ResponseEntity<String> updateAboutMeCommentary (@RequestBody CommentaryWrapper comment){
		scs.updateAboutMeCommentary(
				comment.comment, 
				comment.screeningId);
		return new ResponseEntity<String>("Update introComment Completed", HttpStatus.OK); 
	}
	
	/**
	 * Create a SoftSkillViolation for each ViolationID in the RequestBody, and associates it with the given Screening
	 * 
	 * @param violationFlag - a ViolationFlagWrapper that contains an array of ViolationIds, comment, time of violation, and screeningId
	 * @return An HttpStatus of OK signaling the successful entry of SoftSkillViolation objects.
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
	 * Starts a screening by putting the screening into the database and returning the screeningId
	 * 
	 * @return A ResponseEntity containing a screeningId and an HttpStatus of OK
	 */
	@RequestMapping(value = "/screening/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createScreening(
			@RequestBody SimpleScreening simpleScreening){
		
		SimpleScreening screening = simpleScreening;
		SimpleScreening i = screeningRepository.save(screening);
		return new ResponseEntity<>(i.getScreeningId(),HttpStatus.OK);
	}
	
	/**
	 * Persists general commentary to a Screening by its unique id.
	 * 
	 * @param comment - CommentaryWrapper that represent a comment and screeningId
	 * @return A ResponseEntity containing a success message and an HttpStatus of OK
	 */
	@RequestMapping(value = "/screening/generalcomment", method = RequestMethod.POST)
	public ResponseEntity<String> storeGeneralComment(@RequestBody CommentaryWrapper comment){
		scs.updateGeneralCommentary(comment.comment, comment.screeningId);
		return new ResponseEntity<String>( "Update General Comment Success!",HttpStatus.OK);
	}
	
	/**
	 * End a Screening and update the information by screeningId
	 * 
	 * @param simpleScreening - the status, softSkillsVerdict, softSkillsCommentary, endDateTime, compositeScore, and screeningId of a completed screening.
	 * @return An HttpStatus of OK signalling the successful entry of a screening.
	 */
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
	
	/**
	 * Get screenings based on the status provided.
	 * 
	 * @param status - A string notifying whether the screening is pending or complete.
	 * @return - List of SimpleScreening objects corresponding to status.
	 */
	@RequestMapping(value="/screening/getScreening/status/{status}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleScreening>> getScreenings(@PathVariable(value="status") String status){
		return new ResponseEntity<List<SimpleScreening>>(screeningRepository.findByStatus(status), HttpStatus.OK);
	}
}
