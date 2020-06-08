package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_EMAIL")
@Table(name = "member_email")
public class MemberEmail extends BaseEntity {

	@Column(name = "email", columnDefinition = "NVARCHAR(250)")
	private String email;

	@Column(name = "is_primary")
	private long isPrimary;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	@ManyToOne
	@JoinColumn(name = "member_member_id")
	private Member memberMemberId;

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

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
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
