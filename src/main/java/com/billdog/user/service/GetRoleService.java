package com.billdog.user.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.repository.NamePrefixMasterRepository;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RoleNavigationScreensRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.view.ViewResponse;

@Service
public class GetRoleService {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CreateRoleService.class);

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	NamePrefixMasterRepository namePrefixMasterRepository;

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Autowired
	RoleNavigationScreensRepository roleNavigationScreensRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	NavigationScreenRepository navigationScreenRepository;

	public ResponseEntity<ViewResponse> createRole(CreateRoleRequest createRoleRequest) {
		LOGGER.info("create role method started..!");

		Optional<SystemUsers> userOptional = systemUsersrepository.findById(createRoleRequest.getUserId());
		if (!userOptional.isPresent()) {
			throw new InValidInputException("userID not found with " + createRoleRequest.getUserId());
		}
		
		return null;
	}

	public ResponseEntity<ViewResponse> getRoles(Long userId) {
		Optional<SystemUsers> userOptional = systemUsersrepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new InValidInputException("User id not found with " + userId);
		}
		return null;
	}

}
