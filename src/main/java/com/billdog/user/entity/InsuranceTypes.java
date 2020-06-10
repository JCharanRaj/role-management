package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "INSURANCE_TYPES")
@Table(name = "insurance_types")
public class InsuranceTypes extends BaseEntity{


	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;	
	
	@Column(name = "INSURANCE_TYPE_NAME",columnDefinition = "NVARCHAR(250)")
	private String name;	

	@Column(name = "STATUS",columnDefinition = "NVARCHAR(45)")
	private String status;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	 	
	
}
