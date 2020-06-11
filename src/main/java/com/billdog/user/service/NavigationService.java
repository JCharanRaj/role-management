package com.billdog.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RoleNavigationScreensRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.request.GetRoleScreens;
import com.billdog.user.request.UpdateNavigationScreen;
import com.billdog.user.view.ViewResponse;
import com.billdog.user.view.ViewRoleScreens;

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
	
	@Transactional
	public ResponseEntity<ViewResponse> createNavigationPage(CreateNavigationScreen screen) {
		LOGGER.info("createNavigationPage method started..!");
		
		Optional<Organization> organizationOpt = organizationRepository.findById(screen.getOrganizationId());
		
		if(organizationOpt!=null && !organizationOpt.isPresent()) {
			throw new NoRecordFoundException(Constants.ORGANIZATION_NOT_FOUND + screen.getOrganizationId());
		}
		NavigationScreen navigationScreens=new NavigationScreen();
		if (screen.getParentId() > 0) {
			Optional<NavigationScreen> optional = navigationScreenRepository.findById(screen.getParentId());
			if(!optional.isPresent()) {
			}			
			navigationScreens.setCreatedAt(LocalDateTime.now());
			navigationScreens.setUpdatedAt(LocalDateTime.now());
			navigationScreens.setParentId(optional.get());
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
	@Transactional
	public ResponseEntity<ViewResponse> updateScreenAccess(UpdateNavigationScreen request) {
		LOGGER.info("updateScreenAccess method starts..!");
		Optional<SystemUsers> userOptional = systemUsersrepository.findById(request.getUserId());
		if (!userOptional.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + request.getUserId());
		}
		List<RoleNavigationScreens> screenRequests = new ArrayList<>();
		request.getUpdateScreens().forEach(screen -> {
			Optional<RoleNavigationScreens> optional = roleNavigationScreensRepository.findById(screen.getId());
			if (!optional.isPresent()) {
				throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + request.getUserId());
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
	
	/*
	 * This method will take userId and roleId as input and provide all screens that
	 * are mapped with a role in an organization.
	 */
	@Transactional
	public ResponseEntity<ViewResponse> getRoleScreens(GetRoleScreens getRoleScreens, Roles roles) {
		LOGGER.info("Fetching all screens for role id:: " + roles.getId());
		List<RoleNavigationScreens> navigationScreens = roleNavigationScreensRepository
				.findByRoleIdAndOrganizationId(roles, roles.getOrganizationId());

		List<ViewRoleScreens> roleScreensList = new ArrayList<>();
		navigationScreens.forEach(screen -> {
			ViewRoleScreens roleScreens = new ViewRoleScreens();
			roleScreens.setId(screen.getId());
			roleScreens.setNavigation(screen.getNavigationScreensId().getName());
			roleScreens.setPageName(screen.getNavigationScreensId().getName());
			roleScreens.setReadAccess(screen.isReadAccess());
			roleScreens.setWriteAccess(screen.isWriteAccess());
			List<ViewRoleScreens> roleScreenList = new ArrayList<>();
			if (screen.getNavigationScreensId().getParentId() == null) {
				screen.getNavigationScreensId().getNavigationScreens().forEach(childScreen -> {
					ViewRoleScreens roleScreen = new ViewRoleScreens();
					roleScreen.setId(childScreen.getId());
					roleScreen.setNavigation(childScreen.getName());
					roleScreen.setPageName(childScreen.getName());
					roleScreen.setReadAccess(screen.isReadAccess());
					roleScreen.setWriteAccess(screen.isWriteAccess());
					List<ViewRoleScreens> roleScreensList2 = new ArrayList<>();
					childScreen.getNavigationScreens().forEach(childScreen2 -> {
						ViewRoleScreens roleScreen2 = new ViewRoleScreens();
						roleScreen2.setId(childScreen2.getId());
						roleScreen2.setNavigation(childScreen2.getName());
						roleScreen2.setPageName(childScreen2.getName());
						roleScreensList2.add(roleScreen2);
					});
					roleScreen.setRoleScreens(roleScreensList2);
					roleScreenList.add(roleScreen);
				});
			} else {
				return;
			}
			
			roleScreens.setRoleScreens(roleScreenList);
			roleScreensList.add(roleScreens);
		});

		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(getRoleScreens.getUserId());
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setData(roleScreensList);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private HashMap<NavigationScreen, List<RoleNavigationScreens>> setNavigationScreens(
			List<RoleNavigationScreens> navigationScreens) {

		HashMap<NavigationScreen, List<RoleNavigationScreens>> navigationScreensMap = new HashMap<>();
		navigationScreens.stream().forEach(screen -> {
			List<RoleNavigationScreens> screenByParent = new ArrayList<>();
			if (navigationScreensMap.containsKey(screen)
					&& screen.getNavigationScreensId().getParentId() !=null) {
				screenByParent = navigationScreensMap.get(screen.getNavigationScreensId());
				screenByParent.add(screen);
				navigationScreensMap.put(screen.getNavigationScreensId(), screenByParent);
			} else {
				screenByParent.add(screen);
				navigationScreensMap.put(screen.getNavigationScreensId(), screenByParent);
			}
		});
		return navigationScreensMap;
	}

	private List<ViewResponse> getNavigationScreens(List<RoleNavigationScreens> navigationScreens) {
		navigationScreens.forEach(screen -> {
			ViewRoleScreens roleScreens = new ViewRoleScreens();
			roleScreens.setId(screen.getId());
			roleScreens.setNavigation(screen.getNavigationScreensId().getName());
			roleScreens.setPageName(screen.getNavigationScreensId().getName());
			roleScreens.setReadAccess(screen.isReadAccess());
			roleScreens.setWriteAccess(screen.isWriteAccess());
			List<NavigationScreen> list = navigationScreenRepository.findByParentId(screen.getNavigationScreensId());
			list.forEach(screen2 -> {
				ViewRoleScreens roleScreen = new ViewRoleScreens();
				roleScreen.setId(screen.getId());
				roleScreen.setNavigation(screen.getNavigationScreensId().getName());
				roleScreen.setPageName(screen.getNavigationScreensId().getName());
				roleScreen.setReadAccess(screen.isReadAccess());
				roleScreen.setWriteAccess(screen.isWriteAccess());
			});
		});

		return null;
	}


}
