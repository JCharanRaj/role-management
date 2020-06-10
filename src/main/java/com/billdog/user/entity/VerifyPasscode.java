package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "VERIFY_PASSCODE")
@Table(name = "verify_passcode")
public class VerifyPasscode extends BaseEntity {

	@Column(name = "email", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "passcode", columnDefinition = "NVARCHAR(250)")
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
