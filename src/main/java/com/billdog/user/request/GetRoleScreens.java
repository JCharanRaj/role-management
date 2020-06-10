package com.billdog.user.request;

import javax.validation.constraints.NotNull;

public class GetRoleScreens {

	@NotNull(message = "Roleid must not be null")
	private long roleId;

	@NotNull(message = "Userid must not be null")
	private long userId;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
