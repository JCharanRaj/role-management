package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "COUNTRY_PHONE_CODE_MASTER")
@Table(name = "country_phone_code_master")
public class CountryPhoneCodeMaster extends BaseEntity {

	@Column(name = "phone_number_code")
	private long phoneNumberCode;

	@Column(name = "country_master_id")
	private long countryMasterId;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "organisation_id")
	private long organsation_id;

	public long getPhoneNumberCode() {
		return phoneNumberCode;
	}

	public void setPhoneNumberCode(long phoneNumberCode) {
		this.phoneNumberCode = phoneNumberCode;
	}

	public long getCountryMasterId() {
		return countryMasterId;
	}

	public void setCountryMasterId(long countryMasterId) {
		this.countryMasterId = countryMasterId;
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