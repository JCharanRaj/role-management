package com.billdog.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_FAMILY")
@Table(name = "member_family")
public class MemberFamily extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "RELATIONSHIP_MASTER_ID")
	private RelationshipMaster relationShipMasterId;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member memberId;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	public RelationshipMaster getRelationShipMasterId() {
		return relationShipMasterId;
	}

	public void setRelationShipMasterId(RelationshipMaster relationShipMasterId) {
		this.relationShipMasterId = relationShipMasterId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}
	

}
