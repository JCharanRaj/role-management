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
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;	
	
	@Column(name = "MEMBER_TYPES_NAME",columnDefinition = "NVARCHAR(250)")
	private String typeName;	

	@Column(name = "STATUS",columnDefinition = "NVARCHAR(250)")
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