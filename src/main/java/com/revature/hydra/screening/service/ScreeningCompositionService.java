package com.revature.hydra.screening.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleScreening;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.SoftSkillViolation;
import com.revature.beans.ViolationType;
import com.revature.hydra.screening.controller.ScreeningController;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.data.SoftSkillViolationRepository;
import com.revature.hydra.screening.data.ViolationTypeRepository;

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
	
	/*
	 * @param
	 * Delete Violation by ViolationId
	 */
	public void deleteViolation(Integer violationId) {
		ViolationType violationType = violationRepository.findByViolationTypeId(violationId);
		softSkillViolationRepository.deleteViolationByViolationType(violationType.getViolationTypeText());
	}	
	
	/*
	 * @param
	 * Update aboutMeCommentary by ScreeningId
	 */
	public void updateAboutMeCommentary(String aboutMeCommentary, Integer screeningId) {
		screeningRepository.updateaboutMeCommentaryByScreeningId(aboutMeCommentary, screeningId);
	}
	
	/*
	 * @param
	 * Get SoftSkillViolations by ScreeningId
	 */
	public List<SoftSkillViolation> softSkillViolationsByScreeningId (Integer screeningId){
		SoftSkillViolation ss = new SoftSkillViolation();
		List<SoftSkillViolation> sv = screeningRepository.findSoftSkillViolationsByScreeningId(new SimpleScreening(screeningId));
		return sv;
	}
	
	/*
	 * Get Violation Types
	 */
	public List<ViolationType> violationTypes (){
		List<ViolationType> vt = violationRepository.findAllViolationTypes();
		return  vt;
	}
	
	/*
	 *  @param
	 *  Update GeneralCommentary By ScreeningId
	 */
	public void updateGeneralCommentary(String generalCommentary, Integer screeningId) {
		screeningRepository.changeGeneralCommentaryByScreeningId(generalCommentary, screeningId);
	}
}
