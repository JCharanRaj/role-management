package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name = "ORGANIZATION")
@Table(name = "organization")
public class Organization extends BaseEntity{

	@Column(name = "organization_name",columnDefinition = "NVARCHAR(250)")
	private String name;
	
	@Column(name = "status",columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "phone_number",columnDefinition = "NVARCHAR(250)")
	private String phoneNumber;	

	@Column(name = "fax_number",columnDefinition = "NVARCHAR(250)")
	private String faxNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	

}
