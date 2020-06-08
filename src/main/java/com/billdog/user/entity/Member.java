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

	@Column(name = "member_id")
	private long memberId;

	@Column(name = "first_name", columnDefinition = "NVARCHAR(250)")
	private String firstName;

	@Column(name = "middle_name", columnDefinition = "NVARCHAR(250)")
	private String middleName;

	@Column(name = "last_name", columnDefinition = "NVARCHAR(250)")
	private String lastName;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "sfdc_updated_time")
	private LocalDateTime sfdcUpdatedTime;

	@Column(name = "locked")
	private long locked;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	@ManyToOne
	@JoinColumn(name = "member_type_master_id")
	private MemberTypeMaster memberTypeMasterId;

	@Column(name = "phone_number")
	private long phoneNumber;

	@ManyToOne
	@JoinColumn(name = "country_phone_code_master_id")
	private CountryPhoneCodeMaster countryPhoneCodeMasterId;

	@ManyToOne
	@JoinColumn(name = "name_prefix_master_id")
	private NamePrefixMaster namePrefixMasterId;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

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

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
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
