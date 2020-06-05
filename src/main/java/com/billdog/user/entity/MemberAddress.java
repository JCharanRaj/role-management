package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "MEMBER_ADDRESS")
@Table(name = "member_address")
public class MemberAddress extends BaseEntity {

	@Column(name = "street", columnDefinition = "NVARCHAR(250)")
	private String street;

	@Column(name = "city_name", columnDefinition = "NVARCHAR(250)")
	private String cityName;

	@Column(name = "organisation_id")
	private long organsationId;

	@Column(name = "state_master_id")
	private long stateMasterId;

	@Column(name = "country_master_id")
	private long countryMasterId;

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

	public long getOrgansationId() {
		return organsationId;
	}

	public void setOrgansationId(long organsationId) {
		this.organsationId = organsationId;
	}

	public long getStateMasterId() {
		return stateMasterId;
	}

	public void setStateMasterId(long stateMasterId) {
		this.stateMasterId = stateMasterId;
	}

	public long getCountryMasterId() {
		return countryMasterId;
	}

	public void setCountryMasterId(long countryMasterId) {
		this.countryMasterId = countryMasterId;
	}

	}
