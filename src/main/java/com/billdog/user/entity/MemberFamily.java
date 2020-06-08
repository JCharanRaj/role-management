package com.billdog.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_FAMILY")
@Table(name = "member_family")
public class MemberFamily extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "relationship_master_id")
	private RelationshipMaster relationShipMasterId;

	@ManyToOne
	@JoinColumn(name = "member_member_id")
	private Member memberMemberId;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	public RelationshipMaster getRelationShipMasterId() {
		return relationShipMasterId;
	}

	public void setRelationShipMasterId(RelationshipMaster relationShipMasterId) {
		this.relationShipMasterId = relationShipMasterId;
	}

	public Member getMemberMemberId() {
		return memberMemberId;
	}

	public void setMemberMemberId(Member memberMemberId) {
		this.memberMemberId = memberMemberId;
	}

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
	}

}
