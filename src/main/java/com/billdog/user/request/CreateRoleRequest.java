package com.billdog.user.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateRoleRequest {
	
	@NotBlank(message = "Role name is mandatory")
	private String name;

	@NotNull(message = "Userid must not be null")
	private long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
