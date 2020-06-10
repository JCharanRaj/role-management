package com.billdog.user.request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class UpdateNavigationScreen {

	@NotNull(message = "Userid must not be null")
	private Long userId;

	private List<UpdateScreenRequest> updateScreens;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<UpdateScreenRequest> getUpdateScreens() {
		return updateScreens;
	}

	public void setUpdateScreens(List<UpdateScreenRequest> updateScreens) {
		this.updateScreens = updateScreens;
	}

}
