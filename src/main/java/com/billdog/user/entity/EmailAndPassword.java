package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "EMAIL_AND_PASSWORD")
@Table(name = "email_and_Password")
public class EmailAndPassword extends BaseEntity {

	@Column(name = "email", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "password", columnDefinition = "NVARCHAR(250)")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
