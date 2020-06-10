package com.billdog.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "USER_ROLE_MAP")
@Table(name = "user_role_map")
public class UserRoleMap extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Roles roleId;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member memberId;


	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public Roles getRoleId() {
		return roleId;
	}

	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

}
