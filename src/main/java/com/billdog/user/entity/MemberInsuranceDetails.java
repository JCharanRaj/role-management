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
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organizationId;	

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member memberId;	
	
	@Column(name = "INSURANCE_TYPE_NAME",columnDefinition = "NVARCHAR(250)")
	private String typeName;	

	
	@Column(name = "PCP", columnDefinition = "integer default 0")
	private int pcp;	

	@Column(name = "SPEC", columnDefinition = "integer default 0")
	private int spec;
	

	@Column(name = "ER", columnDefinition = "integer default 0")
	private int er;	

	@Column(name = "DED", columnDefinition = "integer default 0")
	private int ded;

	public Organization getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Organization organizationId) {
		this.organizationId = organizationId;
	}

	public Member getMemberId() {
		return memberId;
	}

	public void setMemberId(Member memberId) {
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