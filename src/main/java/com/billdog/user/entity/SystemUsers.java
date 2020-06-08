package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "SYSTEM_USERS")
@Table(name = "system_users")
public class SystemUsers extends BaseEntity {

	@Column(name = "first_name", columnDefinition = "NVARCHAR(250)")
	private String firstName;

	@Column(name = "middle_name", columnDefinition = "NVARCHAR(250)")
	private String middleName;

	@Column(name = "last_name", columnDefinition = "NVARCHAR(250)")
	private String lastName;

	@Column(name = "email", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "mobile_number", columnDefinition = "NVARCHAR(250)")
	private String mobileNumber;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsationId;

	@ManyToOne
	@JoinColumn(name = "role_Id")
	private Roles roleId;

	@ManyToOne
	@JoinColumn(name = "name_prefix_master_id")
	private NamePrefixMaster namePrefixMasterid;

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

	public Organization getOrgansationId() {
		return organsationId;
	}

	public void setOrgansationId(Organization organsationId) {
		this.organsationId = organsationId;
	}

	public NamePrefixMaster getNamePrefixMasterid() {
		return namePrefixMasterid;
	}

	public void setNamePrefixMasterid(NamePrefixMaster namePrefixMasterid) {
		this.namePrefixMasterid = namePrefixMasterid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Roles getRoleId() {
		return roleId;
	}

	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

}