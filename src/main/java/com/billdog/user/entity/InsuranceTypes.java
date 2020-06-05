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
	@JoinColumn(name = "organization_id")
	private Organization organizationId;	
	
	@Column(name = "insurance_type_name",columnDefinition = "NVARCHAR(250)")
	private String name;	

	@Column(name = "status",columnDefinition = "NVARCHAR(45)")
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
