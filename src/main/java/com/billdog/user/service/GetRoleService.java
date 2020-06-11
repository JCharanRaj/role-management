package com.billdog.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.Constants;
import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NamePrefixMasterRepository;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RoleNavigationScreensRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.view.ViewResponse;
import com.billdog.user.view.ViewRole;

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

	/*
	 * This method will take userId as input and provide all all roles present in an
	 * organization.
	 */
	public ResponseEntity<ViewResponse> getRoles(Long userId) {
		LOGGER.info("Fetching all roles for user id:: " + userId);
		Optional<SystemUsers> userOptional = systemUsersrepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + userId);

		}

		List<Roles> roles = rolesRepository.findByOrganizationId(userOptional.get().getOrganizationId());
		List<ViewRole> viewRoles = roles.stream().map(role -> getRole(role)).collect(Collectors.toList());

		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.ROLE_CREATED);
		viewResponse.setData(viewRoles);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);
	}

	private ViewRole getRole(Roles role) {
		ViewRole viewRole = new ViewRole();
		viewRole.setName(role.getRole());
		viewRole.setRoleId(role.getId());
		return viewRole;
	}


}
