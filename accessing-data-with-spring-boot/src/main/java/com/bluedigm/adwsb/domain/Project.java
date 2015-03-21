package com.bluedigm.adwsb.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Project {

	@Id
	private String id;

	private Date start;

	private Date end;

	private String name;

	private String memo;

	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [id=");
		builder.append(id);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", name=");
		builder.append(name);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
