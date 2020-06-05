package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "GENDER_MASTER")
@Table(name = "gender_master")
public class GenderMaster extends BaseEntity {

	@Column(name = "gender", columnDefinition = "NVARCHAR(250)")
	private String gender;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "organisation_id")
	private long organsation_id;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(long organsation_id) {
		this.organsation_id = organsation_id;
	}

}
