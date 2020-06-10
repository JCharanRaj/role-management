package com.billdog.user.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateUserRequest {

	@NotBlank(message = "Please enter First name")
	private String firstName;
	@NotBlank(message = "Please enter Last name")
	private String lastName;

	private String middleName;

	@NotBlank(message = "Please enter Email")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Please enter Mobile Number")
	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Invalid mobile number")
	private String mobileNumber;

	@NotNull(message = "RoleId must not be null")
	private long roleId;

	@NotNull(message = "UserId must not be null")
	private long userId;

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
