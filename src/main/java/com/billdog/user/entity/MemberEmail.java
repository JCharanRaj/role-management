package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "MEMBER_EMAIL")
@Table(name = "member_email")
public class MemberEmail extends BaseEntity {

	@Column(name = "email", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "is_primary")
	private long isPrimary;

	@Column(name = "organisation_id")
	private long organsation_id;

	@Column(name = "member_member_id")
	private long memberMemberId;

	@Column(name = "password", columnDefinition = "NVARCHAR(250)")
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

	public long getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(long organsation_id) {
		this.organsation_id = organsation_id;
	}

	public long getMemberMemberId() {
		return memberMemberId;
	}

	public void setMemberMemberId(long memberMemberId) {
		this.memberMemberId = memberMemberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
