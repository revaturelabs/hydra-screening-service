package com.revature.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="SOFT_SKILL_VIOLATION")
public class SoftSkillViolation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SOFT_SKILL_VIOLATION_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SOFT_SKILL_VIOLATION_SEQUENCE",sequenceName="SOFT_SKILL_VIOLATION_SEQUENCE")
	@Column(name="SOFT_SKILL_VIOLATION_ID")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCREENING_ID")
	private SimpleScreening screeningId;
	
	@Column(name="VIOLATION_TYPE_ID")
	private Integer violationId;
	
	@Column(name="SOFT_SKILL_VIOLATION_COMMENT")
	private String comment;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME")
	private Date Time;
	
	public SoftSkillViolation(int id, SimpleScreening screeningId, Integer violationId, String comment, Date time) {
		super();
		this.id = id;
		this.screeningId = screeningId;
		this.violationId = violationId;
		this.comment = comment;
		Time = time;
	}
	
	public SoftSkillViolation(SimpleScreening screeningId, Integer violationId, String comment, Date time) {
		super();
		this.screeningId = screeningId;
		this.violationId = violationId;
		this.comment = comment;
		Time = time;
	}

	public SoftSkillViolation() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimpleScreening getScreeningId() {
		return screeningId;
	}

	public void setScreening(SimpleScreening screeningId) {
		this.screeningId = screeningId;
	}

	public Integer getViolation() {
		return violationId;
	}

	public void setViolation(Integer violationId) {
		this.violationId = violationId;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}
	
}
