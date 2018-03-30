package com.revature.hydra.screening.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.SoftSkillViolation;
import com.revature.beans.ViolationType;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.data.SoftSkillViolationRepository;
import com.revature.hydra.screening.data.ViolationTypeRepository;

/**
 * A service for interacting with the data access repositories
 * 
 * @author batem, sungkwon, echamp
 */
@Service
public class ScreeningCompositionService {

	@Autowired
	private ScreeningRepository screeningRepository;
	@Autowired
	private SoftSkillViolationRepository softSkillViolationRepository;
	@Autowired
	private ViolationTypeRepository violationRepository;
	
	@Autowired
	private ScreeningCompositionMessagingService scms; 
	
	/**
	 * A test class for interacting with the Trainee service.
	 * 
	 * @param id - the unique id of a Trainee
	 * @return A SimpleTrainee object
	 */
	public SimpleTrainee getOneTrainee(Integer id) {
		SimpleTrainee st = scms.sendSingleTraineeRequest(id);
		return st;
	}
	
	/**
	 * Deletes a SoftSkillViolation by its unique id.
	 * 
	 * @param softSkillViolationId - the unique id of a softSkillViolation
	 */
//	@Transactional
	public void deleteSoftSkillViolation(Integer softSkillViolationId) {
		softSkillViolationRepository.delete(softSkillViolationId);
	}
	
	/**
	 * Update aboutMeCommentary by ScreeningId
	 * 
	 * @param aboutMeCommentary - the comment to be persisted to the database.
	 * @param screeningId - the unique id of a screening
	 */
	public void updateAboutMeCommentary(String aboutMeCommentary, Integer screeningId) {
		screeningRepository.changeAboutMeCommentaryByScreeningId(aboutMeCommentary, screeningId);
	}
	
	/**
	 * Returns all SoftSkillViolations related to a screeningId
	 * 
	 * @param screeningId - the unique id of a screening
	 * @return List of SoftSkillViolation objects
	 */
	public List<SoftSkillViolation> softSkillViolationsByScreeningId (Integer screeningId){
		List<SoftSkillViolation> sv = softSkillViolationRepository.findByScreeningId(new SimpleScreening(screeningId));
		return sv;
	}
	
	/**
	 * Returns all ViolationType objects
	 * 
	 * @return List of ViolationType objects
	 */
	public List<ViolationType> violationTypes (){
		List<ViolationType> vt = violationRepository.findAll();
		return  vt;
	}
	
	/**
	 * Update GeneralCommentary By ScreeningId
	 * 
	 * @param generalCommentary - the comment to be persisted to the database
	 * @param screeningId - the unique id of a screening
	 */
	public void updateGeneralCommentary(String generalCommentary, Integer screeningId) {
		screeningRepository.changeGeneralCommentaryByScreeningId(generalCommentary, screeningId);
	}
}
