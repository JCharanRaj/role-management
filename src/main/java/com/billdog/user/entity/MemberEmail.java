package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_EMAIL")
@Table(name = "member_email")
public class MemberEmail extends BaseEntity {

	@Column(name = "EMAIL", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "IS_PRIMARY")
	private long isPrimary;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	@ManyToOne
	@JoinColumn(name = "MEMBER_MEMBER_ID")
	private Member memberMemberId;

	@Column(name = "PASSWORD", columnDefinition = "NVARCHAR(250)")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(long isPrimary) {
		this.isPrimary = isPrimary;
	}


	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public Member getMemberMemberId() {
		return memberMemberId;
	}

	public void setMemberMemberId(Member memberMemberId) {
		this.memberMemberId = memberMemberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
