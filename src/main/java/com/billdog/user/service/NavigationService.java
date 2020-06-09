package com.billdog.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.Constants;
import com.billdog.user.entity.NavigationScreen;
import com.billdog.user.entity.Organization;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.view.ViewResponse;

@Service
public class NavigationService {	

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NavigationService.class);
	
	@Autowired
	NavigationScreenRepository navigationScreenRepository;
	

	@Autowired
	OrganizationRepository organizationRepository;
	
	
	public ResponseEntity<ViewResponse> createNavigationPage(CreateNavigationScreen screen) {
		LOGGER.info("createNavigationPage method started..!");
		
		Optional<Organization> organizationOpt = organizationRepository.findById(screen.getOrganizationId());
		
		if(organizationOpt!=null && !organizationOpt.isPresent()) {
			throw new NoRecordFoundException(Constants.ORGANIZATION_NOT_FOUND_WITH_ID+screen.getOrganizationId());
		}
		NavigationScreen navigationScreens=new NavigationScreen();
		if(screen.getParentId()>0) {
			Optional<NavigationScreen> optional = navigationScreenRepository.findById(screen.getParentId());
			if(!optional.isPresent()) {
				throw new NoRecordFoundException(Constants.NAVIGATION_NOT_FOUND_WITH_ID+screen.getParentId());
			}			
			navigationScreens.setCreatedAt(LocalDateTime.now());
			navigationScreens.setUpdatedAt(LocalDateTime.now());
			navigationScreens.setParent_id(screen.getParentId());
			navigationScreens.setOrganizationId(organizationOpt.get());
			navigationScreens.setName(screen.getName());
			navigationScreens.setUrl(screen.getUrl());
			
		}
		else {
			navigationScreens.setCreatedAt(LocalDateTime.now());
			navigationScreens.setUpdatedAt(LocalDateTime.now());
			navigationScreens.setOrganizationId(organizationOpt.get());
			navigationScreens.setName(screen.getName());
			navigationScreens.setUrl(screen.getUrl());
		}
		navigationScreenRepository.save(navigationScreens);
		ViewResponse viewResponse= new ViewResponse();
		viewResponse.setId(navigationScreens.getId());
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.NAVIGATION_SCREEN_CREATED);
		LOGGER.info("createNavigationPage method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
		
	}
	
	

}
