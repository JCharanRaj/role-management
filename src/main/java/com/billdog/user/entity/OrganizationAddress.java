package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ORGANIZATION_ADDRESS")
@Table(name = "organization_address")
public class OrganizationAddress extends BaseEntity{


	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;	
	
	@Column(name = "ADDRESS_LINE1",columnDefinition = "NVARCHAR(250)")
	private String addressLine1;	

	@Column(name = "ADDRESS_LINE2",columnDefinition = "NVARCHAR(250)")
	private String addressLine2;

	@Column(name = "CITY_NAME",columnDefinition = "NVARCHAR(250)")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	private StateMaster stateId;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private CountryMaster countryId;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateMaster getStateId() {
		return stateId;
	}

	public void setStateId(StateMaster stateId) {
		this.stateId = stateId;
	}

	public CountryMaster getCountryId() {
		return countryId;
	}

	public void setCountryId(CountryMaster countryId) {
		this.countryId = countryId;
	}

	
	
	
}
