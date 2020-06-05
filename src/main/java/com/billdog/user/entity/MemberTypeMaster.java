package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_TYPES_MASTER")
@Table(name = "member_types_master")
public class MemberTypeMaster extends BaseEntity{


	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;	
	
	@Column(name = "member_types_name",columnDefinition = "NVARCHAR(250)")
	private String typeName;	

	@Column(name = "status",columnDefinition = "NVARCHAR(250)")
	private String status;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	
}