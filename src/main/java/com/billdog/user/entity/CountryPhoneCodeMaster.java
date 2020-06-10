package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "COUNTRY_PHONE_CODE_MASTER")
@Table(name = "country_phone_code_master")
public class CountryPhoneCodeMaster extends BaseEntity {

	@Column(name = "PHONE_NUMBER_CODE")
	private long phoneNumberCode;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_MASTER_ID")
	private CountryMaster countryMasterId;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;

	public long getPhoneNumberCode() {
		return phoneNumberCode;
	}

	public void setPhoneNumberCode(long phoneNumberCode) {
		this.phoneNumberCode = phoneNumberCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CountryMaster getCountryMasterId() {
		return countryMasterId;
	}

	public void setCountryMasterId(CountryMaster countryMasterId) {
		this.countryMasterId = countryMasterId;
	}

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}


}