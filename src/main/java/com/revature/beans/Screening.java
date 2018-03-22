/*package com.revature.beans;

import java.util.Date;

public class Screening {
	private Integer screeningId;
	private Trainer trainer;
	private Trainee trainee;
	private Screener screener;
	private Track track;

	private Double compositeScore;
	private String aboutMeCommentary;
	private String generalCommentary;
	private String softSkillCommentary;

	private Date startDateTime;
	private Date endDateTime;
	private Boolean softSkillsVerdict;

	private String status;

	public Screening() {
		super();
	}

	public Screening(Integer screeningId, Trainer trainer, Trainee trainee, Screener screener, Track track, Double compositeScore,
			String aboutMeCommentary, String generalCommentary, String softSkillCommentary, Date startDateTime,
			Date endDateTime, Boolean softSkillsVerdict, String status) {
		super();
		this.screeningId = screeningId;
		this.trainer = trainer;
		this.trainee = trainee;
		this.screener = screener;
		this.track = track;
		this.compositeScore = compositeScore;
		this.aboutMeCommentary = aboutMeCommentary;
		this.generalCommentary = generalCommentary;
		this.softSkillCommentary = softSkillCommentary;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.softSkillsVerdict = softSkillsVerdict;
		this.status = status;
	}

	public Screening(SimpleScreening simpleScreening) {
		super();
		this.compositeScore = simpleScreening.getCompositeScore();
		this.aboutMeCommentary = simpleScreening.getAboutMeCommentary();
		this.generalCommentary = simpleScreening.getGeneralCommentary();
		this.softSkillCommentary = simpleScreening.getSoftSkillCommentary();
		this.startDateTime = simpleScreening.getStartDateTime();
		this.endDateTime = simpleScreening.getEndDateTime();
		this.softSkillsVerdict = simpleScreening.getSoftSkillsVerdict();
		this.status = simpleScreening.getStatus();
	}

	public Integer getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Integer screeningId) {
		this.screeningId = screeningId;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Screener getScreener() {
		return screener;
	}

	public void setScreener(Screener screener) {
		this.screener = screener;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
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
		result = prime * result + ((screeningId == null) ? 0 : screeningId.hashCode());
		result = prime * result + ((softSkillCommentary == null) ? 0 : softSkillCommentary.hashCode());
		result = prime * result + ((softSkillsVerdict == null) ? 0 : softSkillsVerdict.hashCode());
		result = prime * result + ((startDateTime == null) ? 0 : startDateTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((trainee == null) ? 0 : trainee.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		Screening other = (Screening) obj;
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
		if (trainee == null) {
			if (other.trainee != null)
				return false;
		} else if (!trainee.equals(other.trainee))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Screening [screeningId=" + screeningId + ", trainer=" + trainer + ", trainee=" + trainee
				+ ", compositeScore=" + compositeScore + ", aboutMeCommentary=" + aboutMeCommentary
				+ ", generalCommentary=" + generalCommentary + ", softSkillCommentary=" + softSkillCommentary
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", softSkillsVerdict="
				+ softSkillsVerdict + ", status=" + status + "]";
	}

}
*/