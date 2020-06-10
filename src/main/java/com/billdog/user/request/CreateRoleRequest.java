package com.billdog.user.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateRoleRequest {
	
	@NotBlank(message = "Role name is mandatory")
	private String name;

	@NotNull(message = "Userid must not be null")
	private Long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
