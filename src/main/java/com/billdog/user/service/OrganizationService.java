package com.billdog.user.service;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billdog.user.entity.NavigationScreens;
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
		
		
		NavigationScreens navigationScreens=new NavigationScreens();
		navigationScreens.setCreatedAt(LocalDateTime.now());
		navigationScreens.setUpdatedAt(LocalDateTime.now());
		navigationScreens.setOrganizationId(organization);
		
		LOGGER.info("createNavigationPage method ends..!");
		return null;
		
	}
	
	

}
