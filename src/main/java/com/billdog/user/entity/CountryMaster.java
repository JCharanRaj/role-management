package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "COUNTRY_MASTER")
@Table(name = "country_master")
public class CountryMaster extends BaseEntity {

	@Column(name = "COUNTRY_NAME", columnDefinition = "NVARCHAR(250)")
	private String countryName;

	@Column(name = "COUNTRY_CODE", columnDefinition = "NVARCHAR(250)")
	private String countryCode;

	@Column(name = "STATUS", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

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

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	

}
