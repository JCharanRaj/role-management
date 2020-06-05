package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name = "ROLES")
@Table(name = "roles")
public class Roles extends BaseEntity{


	@Audited
	@Column(name = "role")
	private String role;

	@Audited
	@Column(name = "status")
	private String status;
	

	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;
	
	@Audited
	@Column(name = "modified_by",columnDefinition = "NVARCHAR(250)")
	private String modifiedBy;
	

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	

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
