package com.billdog.user.service;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billdog.user.common.Constants;
import com.billdog.user.entity.Organization;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.request.CreateOrganization;
import com.billdog.user.view.ViewResponse;

@Service
public class OrganizationService {
	

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);
	
	@Audited
	OrganizationRepository organizationRepository;
	
	
	public ViewResponse createOrganization(CreateOrganization createOrganization) {
		LOGGER.info("createNavigationPage method started..!");
		
		Organization organization=organizationRepository.findByName(createOrganization.getName());

		ViewResponse response= new ViewResponse();
		
		if(organization !=null) {
			
		}
			Organization newOrganization=new Organization();
			newOrganization.setCreatedAt(LocalDateTime.now());
			newOrganization.setUpdatedAt(LocalDateTime.now());
			newOrganization.setFaxNumber(createOrganization.getFaxNumber());
			newOrganization.setPhoneNumber(createOrganization.getPhoneNumber());
			newOrganization.setStatus("ACTIVE");
			response.setId(newOrganization.getId());
		
		
		LOGGER.info("createNavigationPage method ends..!");
		
		response.setStatusText(Constants.SUCCESS);
		response.setMessage("Member is updated successfully!!");	
		return null;
		
	}
	
	

}
