package com.ordermgmt.notification.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class NotificationSettings {

	@NotNull
	private Boolean active;

	private Date lastNotified;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastNotified() {
		return lastNotified;
	}

	public void setLastNotified(Date lastNotified) {
		this.lastNotified = lastNotified;
	}
}
