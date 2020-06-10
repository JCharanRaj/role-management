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
import com.billdog.user.common.StatusConstants;
import com.billdog.user.entity.NavigationScreen;
import com.billdog.user.entity.RoleNavigationScreens;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.exception.RecordExistsException;
import com.billdog.user.repository.NamePrefixMasterRepository;
import com.billdog.user.repository.NavigationScreenRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RoleNavigationScreensRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateRoleService {

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
	 * create role method takes userid, role name and created a new record and provides response.
	 */
	public ResponseEntity<ViewResponse> createRole(CreateRoleRequest createRoleRequest) {
		LOGGER.info("create role method started..!");

		Optional<SystemUsers> userOptional = systemUsersrepository.findById(createRoleRequest.getUserId());
		if (!userOptional.isPresent()) {
			throw new InValidInputException("user id not found with " + createRoleRequest.getUserId());
		}
		
		Optional<Roles> roleOpt = rolesRepository.findByRoleAndOrganizationId(createRoleRequest.getName(),userOptional.get().getOrganzationId());
		if (roleOpt.isPresent()) {
			throw new RecordExistsException("This role is already exists");
		}		

		Roles role = new Roles();
		role.setCreatedAt(LocalDateTime.now());
		role.setUpdatedAt(LocalDateTime.now());
		role.setOrganizationId(userOptional.get().getOrganzationId());
		role.setRole(createRoleRequest.getName());
		role.setStatus(StatusConstants.ACTIVE);
		rolesRepository.save(role);
		mapScreenswithRole(role);

		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setId(role.getId());
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.ROLE_CREATED);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);

	}

	private void mapScreenswithRole(Roles role) {
		LOGGER.info("Mapping role with navigations screens");
		List<NavigationScreen> screens = navigationScreenRepository.findByOrganizationId(role.getOrganizationId());

		List<RoleNavigationScreens> roleNavigationScreens = new ArrayList<>();
		screens.forEach(screen -> {
			RoleNavigationScreens roleNavigationScreen = new RoleNavigationScreens();
			roleNavigationScreen.setCreatedAt(LocalDateTime.now());
			roleNavigationScreen.setUpdatedAt(LocalDateTime.now());
			roleNavigationScreen.setNavigationScreensId(screen);
			roleNavigationScreen.setRoleId(role);
			roleNavigationScreen.setReadAccess(false);
			roleNavigationScreen.setWriteAccess(false);
			roleNavigationScreen.setOrganizationId(role.getOrganizationId());
			roleNavigationScreens.add(roleNavigationScreen);
		});
		roleNavigationScreensRepository.saveAll(roleNavigationScreens);
		LOGGER.info("Role is mapped with navigations screens");
	}

}
