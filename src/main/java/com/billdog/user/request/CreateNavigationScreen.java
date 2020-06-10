package com.billdog.user.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateNavigationScreen {

	private long parentId;
	@NotBlank(message = "Screen name must not be null")
	private String name;
	@NotNull(message = "Screen url must not be null")
	private String url;
	@NotNull(message = "Organization id must not be null")
	private long organizationId;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

}
