package com.bluedigm.adwsb.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Profile {

	@Id
	private String id;

	private String memberId;

	@DBRef
	private List<Project> projects;

	private String description;

	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [id=");
		builder.append(id);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", projects=");
		builder.append(projects);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

}
