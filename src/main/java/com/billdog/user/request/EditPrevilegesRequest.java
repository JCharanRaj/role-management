package com.billdog.user.request;

import javax.validation.constraints.NotNull;

public class EditPrevilegesRequest {
	
	private long id;
	
	private boolean read;
	
	private boolean write;
	
	@NotNull(message = "Roleid must not be null")
	private long roleId;
	
	@NotNull(message = "Userid must not be null")
	private long userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

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
