package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "RELATIONSHIP_MASTER")
@Table(name = "relationship_master")
public class RelationshipMaster extends BaseEntity {

	@Column(name = "relationship_name", columnDefinition = "NVARCHAR(250)")
	private String relationshipName;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	public String getRelationshipName() {
		return relationshipName;
	}

	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
	}

}
