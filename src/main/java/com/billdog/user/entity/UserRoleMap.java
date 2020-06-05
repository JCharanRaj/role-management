package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "USER_ROLE_MAP")
@Table(name = "user_role_map")
public class UserRoleMap extends BaseEntity {

	@Column(name = "organisation_id")
	private long organisationId;

	@Column(name = "role_id")
	private long roleId;

	@Column(name = "member_id")
	private long memberId;

	public long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(long organisationId) {
		this.organisationId = organisationId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

}
