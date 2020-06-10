package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "RELATIONSHIP_MASTER")
@Table(name = "relationship_master")
public class RelationshipMaster extends BaseEntity {

	@Column(name = "RELATIONSHIP_NAME", columnDefinition = "NVARCHAR(250)")
	private String relationshipName;

	@Column(name = "STATUS", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

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

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	

}
