package com.revature.beans;

import java.util.Date;

public class ScheduledScreening {
	private Trainee trainee;
	private Integer trainer;
	private ScheduledStatus status;
	private Integer scheduledScreeningId;
	private Date scheduledDate;

	public ScheduledScreening(Trainee trainee, Integer trainer, ScheduledStatus status, Date scheduledDate) {
		super();
		this.trainee = trainee;
		this.trainer = trainer;
		this.status = status;
		this.scheduledDate = scheduledDate;
	}

	public ScheduledScreening(Trainee trainee, Integer trainer, ScheduledStatus status, Integer scheduledScreeningId,
			Date scheduledDate) {
		super();
		this.trainee = trainee;
		this.trainer = trainer;
		this.status = status;
		this.scheduledScreeningId = scheduledScreeningId;
		this.scheduledDate = scheduledDate;
	}

	public ScheduledScreening() {
		super();
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Integer getTrainer() {
		return trainer;
	}

	public void setTrainer(Integer trainer) {
		this.trainer = trainer;
	}

	public ScheduledStatus getStatus() {
		return status;
	}

	public void setStatus(ScheduledStatus status) {
		this.status = status;
	}

	public Integer getScheduledScreeningId() {
		return scheduledScreeningId;
	}

	public void setScheduledScreeningId(Integer scheduledScreeningId) {
		this.scheduledScreeningId = scheduledScreeningId;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	@Override
	public String toString() {
		return "ScheduledScreening [trainee=" + trainee + ", trainer=" + trainer + ", status=" + status
				+ ", scheduledScreeningId=" + scheduledScreeningId + ", scheduledDate=" + scheduledDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result + ((scheduledScreeningId == null) ? 0 : scheduledScreeningId.hashCode());
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
		ScheduledScreening other = (ScheduledScreening) obj;
		if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (scheduledScreeningId == null) {
			if (other.scheduledScreeningId != null)
				return false;
		} else if (!scheduledScreeningId.equals(other.scheduledScreeningId))
			return false;
		if (status != other.status)
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

}
