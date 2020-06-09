package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "NAVIGATION_SCREENS_ROLE_MAPPING")
@Table(name = "navigation_screens_role_mapping")
public class RoleNavigationScreens extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles roleId;

	@ManyToOne
	@JoinColumn(name = "navigation_screens_access_id")
	private NavigationScreen navigationScreensId;

	@Column(name = "read_access")
	private boolean readAccess;

	@Column(name = "write_access")
	private boolean writeAccess;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public Roles getRoleId() {
		return roleId;
	}

	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

	public NavigationScreen getNavigationScreensId() {
		return navigationScreensId;
	}

	public void setNavigationScreensId(NavigationScreen navigationScreensId) {
		this.navigationScreensId = navigationScreensId;
	}

	public boolean isReadAccess() {
		return readAccess;
	}

	public void setReadAccess(boolean readAccess) {
		this.readAccess = readAccess;
	}

	public boolean isWriteAccess() {
		return writeAccess;
	}

	public void setWriteAccess(boolean writeAccess) {
		this.writeAccess = writeAccess;
	}

}
