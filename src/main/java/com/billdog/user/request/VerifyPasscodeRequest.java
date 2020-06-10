package com.billdog.user.request;

import javax.validation.constraints.NotBlank;

public class VerifyPasscodeRequest {

	@NotBlank(message = "please enter email")
	private String email;
	@NotBlank(message = "please enter passcode")
	private String passcode;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

}
