package com.billdog.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "MEMBER_INSURANCE_DETAILS")
@Table(name = "member_insurance_details")
public class MemberInsuranceDetails extends BaseEntity{


	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organizationId;	

	@ManyToOne
	@JoinColumn(name = "member_id")
	private member memberId;	
	
	@Column(name = "insurance_type_name",columnDefinition = "NVARCHAR(250)")
	private String typeName;	

	
	@Column(name = "pcp", columnDefinition = "integer default 0")
	private int pcp;	

	@Column(name = "spec", columnDefinition = "integer default 0")
	private int spec;
	

	@Column(name = "er", columnDefinition = "integer default 0")
	private int er;	

	@Column(name = "ded", columnDefinition = "integer default 0")
	private int ded;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public member getMemberId() {
		return memberId;
	}

	public void setMemberId(member memberId) {
		this.memberId = memberId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getPcp() {
		return pcp;
	}

	public void setPcp(int pcp) {
		this.pcp = pcp;
	}

	public int getSpec() {
		return spec;
	}

	public void setSpec(int spec) {
		this.spec = spec;
	}

	public int getEr() {
		return er;
	}

	public void setEr(int er) {
		this.er = er;
	}

	public int getDed() {
		return ded;
	}

	public void setDed(int ded) {
		this.ded = ded;
	}
	
}