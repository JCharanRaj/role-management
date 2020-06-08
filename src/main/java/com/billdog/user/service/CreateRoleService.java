package com.billdog.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.envers.Audited;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.Constants;
import com.billdog.user.entity.NavigationScreens;
import com.billdog.user.entity.Organization;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NavigationScreensRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateRoleService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CreateRoleService.class);
	
	@Audited
	NavigationScreensRepository navigationScreensRepository;
	
	@Audited
	OrganizationRepository organizationRepository;
	
	public ResponseEntity<ViewResponse> createUserRole(CreateRoleRequest roleRequest) {
		LOGGER.info("createNavigationPage method started..!");
		ViewResponse viewResponse= new ViewResponse();
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.NAVIGATION_SCREEN_CREATED);
		LOGGER.info("createNavigationPage method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	
	public ResponseEntity<ViewResponse> createNavigationPage(CreateNavigationScreen screen) {
		LOGGER.info("createNavigationPage method started..!");
		
		Optional<Organization> organizationOpt = organizationRepository.findById(screen.getOrganizationId());
		
		if(!organizationOpt.isPresent()) {
			throw new NoRecordFoundException(Constants.ORGANIZATION_NOT_FOUND_WITH_ID+screen.getOrganizationId());
		}
		NavigationScreens navigationScreens=new NavigationScreens();
		if(screen.getParentId()>0) {
			Optional<NavigationScreens> optional = navigationScreensRepository.findById(screen.getParentId());
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
		ViewResponse viewResponse= new ViewResponse();
		viewResponse.setId(navigationScreens.getId());
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.NAVIGATION_SCREEN_CREATED);
		LOGGER.info("createNavigationPage method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
		
	}
}
