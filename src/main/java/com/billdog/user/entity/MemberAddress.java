package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_ADDRESS")
@Table(name = "member_address")
public class MemberAddress extends BaseEntity {

	@Column(name = "STREET", columnDefinition = "NVARCHAR(250)")
	private String street;

	@Column(name = "CITY_NAME", columnDefinition = "NVARCHAR(250)")
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	@ManyToOne
	@JoinColumn(name = "STATE_MASTER_ID")
	private StateMaster stateMasterId;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_MASTER_ID")
	private CountryMaster countryMasterId;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}	

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public StateMaster getStateMasterId() {
		return stateMasterId;
	}

	public void setStateMasterId(StateMaster stateMasterId) {
		this.stateMasterId = stateMasterId;
	}

	public CountryMaster getCountryMasterId() {
		return countryMasterId;
	}

	public void setCountryMasterId(CountryMaster countryMasterId) {
		this.countryMasterId = countryMasterId;
	}

}
