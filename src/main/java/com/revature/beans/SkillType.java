package com.revature.beans;

public class SkillType {
	
	private Integer skillTypeID;
	
	private String skillTypeName;
	
	private Boolean isActive;

	public SkillType() {
		super();
	}

	public SkillType(String skillTypeName, Boolean isActive) {
		super();
		this.skillTypeName = skillTypeName;
		this.isActive = isActive;
	}

	public Integer getSkillTypeID() {
		return skillTypeID;
	}

	public void setSkillTypeID(Integer skillTypeID) {
		this.skillTypeID = skillTypeID;
	}

	public String getSkillTypeName() {
		return skillTypeName;
	}

	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
