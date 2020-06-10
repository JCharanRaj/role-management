package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "NAVIGATION_SCREENS")
@Table(name = "navigation_screens")
public class NavigationScreen extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;	
	
	@Column(name = "NAME",columnDefinition = "NVARCHAR(250)")
	private String name;	
	
	@Column(name = "URL",columnDefinition = "NVARCHAR(250) default '#'")
	private String url;	

	@Column(name = "PARENT_ID", columnDefinition = "bigint(20) default 0")
	private long parent_id;
	
	@Column(name = "DISPLAY_ORDER", columnDefinition = "bigint(20) default 0")
	private long displayOrder;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		this.displayOrder = displayOrder;
	}
	
}
