package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "COUNTRY_MASTER")
@Table(name = "country_master")
public class CountryMaster extends BaseEntity {

	@Column(name = "country_name", columnDefinition = "NVARCHAR(250)")
	private String countryName;

	@Column(name = "country_code", columnDefinition = "NVARCHAR(250)")
	private String countryCode;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "organisation_id")
	private long organsation_id;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
