package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "COUNTRY_PHONE_CODE_MASTER")
@Table(name = "country_phone_code_master")
public class CountryPhoneCodeMaster extends BaseEntity {

	@Column(name = "phone_number_code")
	private long phoneNumberCode;

	@ManyToOne
	@JoinColumn(name = "country_master_id")
	private CountryMaster countryMasterId;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

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

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
	}

}