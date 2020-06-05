package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
