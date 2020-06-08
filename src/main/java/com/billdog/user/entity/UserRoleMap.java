package com.billdog.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "USER_ROLE_MAP")
@Table(name = "user_role_map")
public class UserRoleMap extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles roleId;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member memberId;

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
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
