package com.billdog.user.view;

import java.util.List;

public class ViewRoleScreens {

	private long id;
	private String navigation;
	private String pageName;
	private boolean readAccess;
	private boolean writeAccess;
	private List<ViewRoleScreens> roleScreens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNavigation() {
		return navigation;
	}

	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
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

	public List<ViewRoleScreens> getRoleScreens() {
		return roleScreens;
	}

	public void setRoleScreens(List<ViewRoleScreens> roleScreens) {
		this.roleScreens = roleScreens;
	}

}
