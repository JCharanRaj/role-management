package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "MEMBER_FAMILY")
@Table(name = "member_family")
public class MemberFamily extends BaseEntity {

	@Column(name = "relationship_master_id")
	private long relationShipMasterId;

	@Column(name = "member_member_id")
	private long memberMemberId;

	@Column(name = "organisation_id")
	private long organsation_id;

	public long getRelationShipMasterId() {
		return relationShipMasterId;
	}

	public void setRelationShipMasterId(long relationShipMasterId) {
		this.relationShipMasterId = relationShipMasterId;
	}

	public long getMemberMemberId() {
		return memberMemberId;
	}

	public void setMemberMemberId(long memberMemberId) {
		this.memberMemberId = memberMemberId;
	}

	public long getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(long organsation_id) {
		this.organsation_id = organsation_id;
	}

}
