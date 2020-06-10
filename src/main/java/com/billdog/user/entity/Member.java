package com.billdog.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER")
@Table(name = "member")
public class Member extends BaseEntity {

	@Column(name = "FIRST_NAME", columnDefinition = "NVARCHAR(250)")
	private String firstName;

	@Column(name = "MIDDLE_NAME", columnDefinition = "NVARCHAR(250)")
	private String middleName;

	@Column(name = "LAST_NAME", columnDefinition = "NVARCHAR(250)")
	private String lastName;

	@Column(name = "STATUS", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "SFDC_UPDATED_TIME")
	private LocalDateTime sfdcUpdatedTime;

	@Column(name = "LOCKED")
	private long locked;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	@ManyToOne
	@JoinColumn(name = "MEMBER_TYPE_MASTER_ID")
	private MemberTypeMaster memberTypeMasterId;

	@Column(name = "PHONE_NUMBER")
	private long phoneNumber;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_PHONE_CODE_MASTER_ID")
	private CountryPhoneCodeMaster countryPhoneCodeMasterId;

	@ManyToOne
	@JoinColumn(name = "NAME_PREFIX_MASTER_ID")
	private NamePrefixMaster namePrefixMasterId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getSfdcUpdatedTime() {
		return sfdcUpdatedTime;
	}

	public void setSfdcUpdatedTime(LocalDateTime sfdcUpdatedTime) {
		this.sfdcUpdatedTime = sfdcUpdatedTime;
	}

	public long getLocked() {
		return locked;
	}

	public void setLocked(long locked) {
		this.locked = locked;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public MemberTypeMaster getMemberTypeMasterId() {
		return memberTypeMasterId;
	}

	public void setMemberTypeMasterId(MemberTypeMaster memberTypeMasterId) {
		this.memberTypeMasterId = memberTypeMasterId;
	}

	public CountryPhoneCodeMaster getCountryPhoneCodeMasterId() {
		return countryPhoneCodeMasterId;
	}

	public void setCountryPhoneCodeMasterId(CountryPhoneCodeMaster countryPhoneCodeMasterId) {
		this.countryPhoneCodeMasterId = countryPhoneCodeMasterId;
	}

	public NamePrefixMaster getNamePrefixMasterId() {
		return namePrefixMasterId;
	}

	public void setNamePrefixMasterId(NamePrefixMaster namePrefixMasterId) {
		this.namePrefixMasterId = namePrefixMasterId;
	}

}
