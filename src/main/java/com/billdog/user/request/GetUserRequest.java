package com.billdog.user.request;

public class GetUserRequest {

	private long Id;
	private long userId;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
