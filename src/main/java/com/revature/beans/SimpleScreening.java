package com.revature.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="SCREENING")
public class SimpleScreening {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SCREENING_SEQUENCE")
	@SequenceGenerator(name="SCREENING_SEQUENCE",sequenceName="SCREENING_SEQUENCE")
	@Column(name="SCREENING_ID")
	private Integer screeningId;
	
	@Column(name="TRAINER_ID")
	private Integer trainerId;
	
	@Column(name="TRAINEE_ID")
	private Integer traineeId;
	
	@Column(name="SKILL_TYPE_ID")
	private Integer skillTypeId;

	@Column(name="COMPOSITE_SCORE")
	private Double compositeScore;
	
	@Column(name="ABOUT_ME_COMMENTARY")
	private String aboutMeCommentary;
	
	@Column(name="GENERAL_COMMENTARY")
	private String generalCommentary;
	
	@Column(name="SOFT_SKILL_COMMENTARY")
	private String softSkillCommentary;

	@Column(name="START_DATE_TIME")
	private Date startDateTime;
	
	@Column(name="END_DATE_TIME")
	private Date endDateTime;
	
	@Column(name="SOFT_SKILL_VERDICT")
	private Boolean softSkillsVerdict;

	@Column(name="STATUS")
	private String status;

	public SimpleScreening() {
		super();
	}

	public SimpleScreening(Integer trainerId, Integer traineeId, Integer skillTypeId, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.trainerId = trainerId;
		this.traineeId = traineeId;
		this.skillTypeId = skillTypeId;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public Double getCompositeScore() {
		return compositeScore;
	}

	public void setCompositeScore(Double compositeScore) {
		this.compositeScore = compositeScore;
	}

	public String getAboutMeCommentary() {
		return aboutMeCommentary;
	}

	public void setAboutMeCommentary(String aboutMeCommentary) {
		this.aboutMeCommentary = aboutMeCommentary;
	}

	public String getGeneralCommentary() {
		return generalCommentary;
	}

	public void setGeneralCommentary(String generalCommentary) {
		this.generalCommentary = generalCommentary;
	}

	public String getSoftSkillCommentary() {
		return softSkillCommentary;
	}

	public void setSoftSkillCommentary(String softSkillCommentary) {
		this.softSkillCommentary = softSkillCommentary;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getSoftSkillsVerdict() {
		return softSkillsVerdict;
	}

	public void setSoftSkillsVerdict(Boolean softSkillsVerdict) {
		this.softSkillsVerdict = softSkillsVerdict;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getScreeningId() {
		return screeningId;
	}
}