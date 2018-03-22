package com.revature.beans;

import java.io.Serializable;
import java.util.Set;

public class Skill implements Serializable {
	private static final long serialVersionUID = 3363756954535297728L;

	private Integer skillId;
	private String skillName;
	private Boolean active;
	private Set<Assessment> assessments;

	/**
	 * Instantiates a new Skill.
	 */
	public Skill() {
		super();
	}

	/**
	 * Create new skill
	 *
	 * @param skillName
	 * @param active
	 */
	public Skill(String skillName, Boolean active) {
		this();
		this.skillName = skillName;
		this.active = active;
	}

	public Skill(SimpleSkill simpleSkill){
		this();
		this.skillId = simpleSkill.getSkillId();
		this.skillName = simpleSkill.getSkillName();
		this.active = simpleSkill.isActive();
	}

	/**
	 * Gets skill id.
	 *
	 * @return the skill id
	 */
	public Integer getSkillId() {
		return skillId;
	}

	/**
	 * Sets skill id.
	 *
	 * @param skillId
	 *            the skill id
	 */
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	/**
	 * Gets skill name.
	 *
	 * @return the skill name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * Sets skill name.
	 *
	 * @param skillName
	 *            the skill name
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Gets assessments.
	 *
	 * @return the assessments
	 */
	public Set<Assessment> getAssessments() {
		return assessments;
	}

	/**
	 * Sets assessments.
	 *
	 * @param assessments
	 *            the assessments
	 */
	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
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
		Skill other = (Skill) obj;
		if (active != other.active)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return skillName;
	}

}
