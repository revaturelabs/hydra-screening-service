package com.revature.hydra.screening.wrapper;

import java.util.Date;

import com.revature.beans.ViolationType;

/**
 * Wrapper class
 */
public class SoftSkillViolationWrapper {
	public Integer violationID;
	public Integer screeningID;
	public ViolationType violationType;
	public Date Time;
	public String Comment;
	public SoftSkillViolationWrapper(Integer violationID, Integer screeningID, ViolationType violationType, Date time,
			String comment) {
		super();
		this.violationID = violationID;
		this.screeningID = screeningID;
		this.violationType = violationType;
		Time = time;
		Comment = comment;
	}
	public Integer getViolationID() {
		return violationID;
	}
	public void setViolationID(Integer violationID) {
		this.violationID = violationID;
	}
	public Integer getScreeningID() {
		return screeningID;
	}
	public void setScreeningID(Integer screeningID) {
		this.screeningID = screeningID;
	}
	public ViolationType getViolationType() {
		return violationType;
	}
	public void setViolationType(ViolationType violationType) {
		this.violationType = violationType;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comment == null) ? 0 : Comment.hashCode());
		result = prime * result + ((Time == null) ? 0 : Time.hashCode());
		result = prime * result + ((screeningID == null) ? 0 : screeningID.hashCode());
		result = prime * result + ((violationID == null) ? 0 : violationID.hashCode());
		result = prime * result + ((violationType == null) ? 0 : violationType.hashCode());
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
		SoftSkillViolationWrapper other = (SoftSkillViolationWrapper) obj;
		if (Comment == null) {
			if (other.Comment != null)
				return false;
		} else if (!Comment.equals(other.Comment))
			return false;
		if (Time == null) {
			if (other.Time != null)
				return false;
		} else if (!Time.equals(other.Time))
			return false;
		if (screeningID == null) {
			if (other.screeningID != null)
				return false;
		} else if (!screeningID.equals(other.screeningID))
			return false;
		if (violationID == null) {
			if (other.violationID != null)
				return false;
		} else if (!violationID.equals(other.violationID))
			return false;
		if (violationType == null) {
			if (other.violationType != null)
				return false;
		} else if (!violationType.equals(other.violationType))
			return false;
		return true;
	}
	public SoftSkillViolationWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
