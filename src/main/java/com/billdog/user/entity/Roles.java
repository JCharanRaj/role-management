package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ROLES")
@Table(name = "roles")
public class Roles extends BaseEntity{


	@Column(name = "role")
	private String role;

	@Column(name = "status")
	private String status;	
	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;
	

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
