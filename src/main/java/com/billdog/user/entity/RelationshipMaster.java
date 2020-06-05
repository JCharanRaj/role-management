package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "RELATIONSHIP_MASTER")
@Table(name = "relationship_master")
public class RelationshipMaster extends BaseEntity {

	@Column(name = "relationship_name", columnDefinition = "NVARCHAR(250)")
	private String relationshipName;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@Column(name = "organisation_id")
	private long organsation_id;

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

	public long getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(long organsation_id) {
		this.organsation_id = organsation_id;
	}

}
