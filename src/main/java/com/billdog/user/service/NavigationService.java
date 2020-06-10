package com.billdog.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.Constants;
import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.NavigationScreen;
import com.billdog.user.entity.Organization;
import com.billdog.user.entity.RoleNavigationScreens;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RoleNavigationScreensRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.request.UpdateNavigationScreen;
import com.billdog.user.view.ViewResponse;

@Service
public class NavigationService {	

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NavigationService.class);
	@Autowired
	NavigationScreenRepository navigationScreenRepository;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Autowired
	RoleNavigationScreensRepository roleNavigationScreensRepository;
	
	
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


	/*
	 * this method takes list of role UpdateScreenRequest objects to update screen
	 * access by role
	 * 
	 */
	public ResponseEntity<ViewResponse> updateScreenAccess(UpdateNavigationScreen request) {
		LOGGER.info("updateScreenAccess method starts..!");
		Optional<SystemUsers> userOptional = systemUsersrepository.findById(request.getUserId());
		if (!userOptional.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.USER_NOT_FOUND + request.getUserId());
		}
		List<RoleNavigationScreens> screenRequests = new ArrayList<>();
		request.getUpdateScreens().forEach(screen -> {
			Optional<RoleNavigationScreens> optional = roleNavigationScreensRepository.findById(screen.getId());
			if (!optional.isPresent()) {

			}
			RoleNavigationScreens screenRequest = optional.get();
			screenRequest.setWriteAccess(screen.isWriteAccess());
			screenRequest.setReadAccess(screen.isReadAccess());
			screenRequests.add(screenRequest);
		});

		roleNavigationScreensRepository.saveAll(screenRequests);
		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(request.getUserId());
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.NAVIGATION_SCREEN_ACCESS_UPDATED);
		LOGGER.info("updateScreenAccess method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}
	
	

}
