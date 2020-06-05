package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "NAVIGATION_SCREENS_ACCESS")
@Table(name = "navigation_screens_access")
public class NavigationScreens extends BaseEntity{


	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;	
	
	@Column(name = "name",columnDefinition = "NVARCHAR(250)")
	private String name;	

	@Column(name = "parent_id")
	private long parent_id;
	

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

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	
}
