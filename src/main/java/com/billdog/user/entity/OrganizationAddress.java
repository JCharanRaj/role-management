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
	@JoinColumn(name = "organization_id")
	private Organization organizationId;	
	
	@Column(name = "address_line1",columnDefinition = "NVARCHAR(250)")
	private String addressLine1;	

	@Column(name = "address_line2",columnDefinition = "NVARCHAR(250)")
	private String addressLine2;

	@Column(name = "city_name",columnDefinition = "NVARCHAR(250)")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateMaster stateId;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
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
