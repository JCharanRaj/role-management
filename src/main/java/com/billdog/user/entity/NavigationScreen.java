package com.billdog.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "NAVIGATION_SCREENS")
@Table(name = "navigation_screens")
public class NavigationScreen extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;

	@Column(name = "NAME", columnDefinition = "NVARCHAR(250)")
	private String name;

	@Column(name = "URL", columnDefinition = "NVARCHAR(250) default '#'")
	private String url;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "PARENT_ID", columnDefinition = "bigint(20) default 0")
	private NavigationScreen parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<NavigationScreen> navigationScreens;

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

	public NavigationScreen getParentId() {
		return parentId;
	}

	public void setParentId(NavigationScreen parentId) {
		this.parentId = parentId;
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

	public List<NavigationScreen> getNavigationScreens() {
		return navigationScreens;
	}

	public void setNavigationScreens(List<NavigationScreen> navigationScreens) {
		this.navigationScreens = navigationScreens;
	}

}
