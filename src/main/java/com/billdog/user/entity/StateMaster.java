package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ORGANIZATION_ADDRESS")
@Table(name = "organization_address")
public class StateMaster extends BaseEntity{


	@Column(name = "state_name",columnDefinition = "NVARCHAR(45)")
	private String name;
	

	@Column(name = "state_code",columnDefinition = "NVARCHAR(45)")
	private String code;	

	@Column(name = "status",columnDefinition = "NVARCHAR(45)")
	private String status;	

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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