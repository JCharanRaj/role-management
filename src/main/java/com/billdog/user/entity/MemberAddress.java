package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_ADDRESS")
@Table(name = "member_address")
public class MemberAddress extends BaseEntity {

	@Column(name = "street", columnDefinition = "NVARCHAR(250)")
	private String street;

	@Column(name = "city_name", columnDefinition = "NVARCHAR(250)")
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	@ManyToOne
	@JoinColumn(name = "state_master_id")
	private StateMaster stateMasterId;

	@ManyToOne
	@JoinColumn(name = "country_master_id")
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

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
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
