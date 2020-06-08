package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "NAME_PREFIX_MASTER")
@Table(name = "name_prifix_master")
public class NamePrefixMaster extends BaseEntity {

	@Column(name = "prefix", columnDefinition = "NVARCHAR(250)")
	private String prefix;

	@Column(name = "status", columnDefinition = "NVARCHAR(250)")
	private String status;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organsation_id;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Organization getOrgansation_id() {
		return organsation_id;
	}

	public void setOrgansation_id(Organization organsation_id) {
		this.organsation_id = organsation_id;
	}

}
