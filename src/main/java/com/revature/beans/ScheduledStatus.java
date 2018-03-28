package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ScheduledStatus {
	@JsonProperty("PENDING")
	ROLE_VP,
	@JsonProperty("INTERVIEWER")
	ROLE_PANEL
}
