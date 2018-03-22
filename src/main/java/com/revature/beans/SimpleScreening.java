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
	
	@Column(name="SCREENER_ID")
	private Integer screenerId;
	
	@Column(name="TRACK_ID")
	private Integer trackId;

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

	@Column(name="ASTATUS")
	private String status;

	public SimpleScreening() {
		super();
	}

	public SimpleScreening(Integer screeningId, Integer trainerId, Integer traineeId, Integer screenerId,
			Integer trackId, Double compositeScore, String aboutMeCommentary, String generalCommentary,
			String softSkillCommentary, Date startDateTime, Date endDateTime, Boolean softSkillsVerdict,
			String status) {
		super();
		this.screeningId = screeningId;
		this.trainerId = trainerId;
		this.traineeId = traineeId;
		this.screenerId = screenerId;
		this.trackId = trackId;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

/*	public SimpleScreening(Screening screening) {
		super();
		this.screeningId = screening.getScreeningId();
		this.trainerId = screening.getTrainer().getTrainerId();
		this.traineeId = screening.getTrainee().getTraineeId();
		this.screenerId = screening.getScreener().getScreenerId();
		this.trackId = screening.getTrack().getTrackId();;
		this.compositeScore = screening.getCompositeScore();
		this.aboutMeCommentary = screening.getAboutMeCommentary();
		this.generalCommentary = screening.getGeneralCommentary();
		this.softSkillCommentary = screening.getSoftSkillCommentary();
		this.startDateTime = screening.getStartDateTime();
		this.endDateTime = screening.getEndDateTime();
		this.softSkillsVerdict = screening.getSoftSkillsVerdict();
		this.status = screening.getStatus();
	}*/

	public Integer getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
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

	public Integer getScreenerId() {
		return screenerId;
	}

	public void setScreenerId(Integer screenerId) {
		this.screenerId = screenerId;
	}

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutMeCommentary == null) ? 0 : aboutMeCommentary.hashCode());
		result = prime * result + ((compositeScore == null) ? 0 : compositeScore.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((generalCommentary == null) ? 0 : generalCommentary.hashCode());
		result = prime * result + ((screenerId == null) ? 0 : screenerId.hashCode());
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
		result = prime * result + ((softSkillCommentary == null) ? 0 : softSkillCommentary.hashCode());
		result = prime * result + ((softSkillsVerdict == null) ? 0 : softSkillsVerdict.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
		result = prime * result + ((traineeId == null) ? 0 : traineeId.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleScreening other = (SimpleScreening) obj;
		if (aboutMeCommentary == null) {
			if (other.aboutMeCommentary != null)
				return false;
		} else if (!aboutMeCommentary.equals(other.aboutMeCommentary))
			return false;
		if (compositeScore == null) {
			if (other.compositeScore != null)
				return false;
		} else if (!compositeScore.equals(other.compositeScore))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (generalCommentary == null) {
			if (other.generalCommentary != null)
				return false;
		} else if (!generalCommentary.equals(other.generalCommentary))
			return false;
		if (screenerId == null) {
			if (other.screenerId != null)
				return false;
		} else if (!screenerId.equals(other.screenerId))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (softSkillCommentary == null) {
			if (other.softSkillCommentary != null)
				return false;
		} else if (!softSkillCommentary.equals(other.softSkillCommentary))
			return false;
		if (softSkillsVerdict == null) {
			if (other.softSkillsVerdict != null)
				return false;
		} else if (!softSkillsVerdict.equals(other.softSkillsVerdict))
			return false;
		if (startDateTime == null) {
			if (other.startDateTime != null)
				return false;
		} else if (!startDateTime.equals(other.startDateTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (trackId == null) {
			if (other.trackId != null)
				return false;
		} else if (!trackId.equals(other.trackId))
			return false;
		if (traineeId == null) {
			if (other.traineeId != null)
				return false;
		} else if (!traineeId.equals(other.traineeId))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleScreening [screeningId=" + screeningId + ", trainerId=" + trainerId + ", traineeId=" + traineeId
				+ ", screenerId=" + screenerId + ", trackId=" + trackId + ", compositeScore=" + compositeScore
				+ ", aboutMeCommentary=" + aboutMeCommentary + ", generalCommentary=" + generalCommentary
				+ ", softSkillCommentary=" + softSkillCommentary + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", softSkillsVerdict=" + softSkillsVerdict + ", status=" + status + "]";
	}
}