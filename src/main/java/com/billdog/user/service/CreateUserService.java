package com.billdog.user.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.entity.NamePrefixMaster;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.NamePrefixMasterRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.request.SearchUsersRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.view.SearchUserDetailsResponse;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateUserService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CreateUserService.class);

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	NamePrefixMasterRepository namePrefixMasterRepository;

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Autowired
	RolesRepository rolesRepository;

	public LoginResponse createUser(CreateUserRequest createUserRequest) {
		LOGGER.info("create user method started..!");

		Optional<SystemUsers> sysUser = systemUsersrepository.findById(createUserRequest.getUserId());
		if (!sysUser.isPresent()) {
			throw new NoRecordFoundException("Organization not found with Id " + createUserRequest.getUserId());
		}
		Optional<NamePrefixMaster> namePrefixMaster = namePrefixMasterRepository.findById((long) 1);
		if (!namePrefixMaster.isPresent()) {
			throw new NoRecordFoundException("Id not found with " + 1);
		}

		Optional<Roles> role = rolesRepository.findById(createUserRequest.getRoleId());
		if (!role.isPresent()) {
			throw new NoRecordFoundException("roleId not found with " + createUserRequest.getRoleId());
		}

		SystemUsers systemUsers = new SystemUsers();
		systemUsers.setCreatedAt(LocalDateTime.now());
		systemUsers.setUpdatedAt(LocalDateTime.now());
		systemUsers.setOrganzationId(sysUser.get().getOrganzationId());
		systemUsers.setFirstName(createUserRequest.getFirstName());
		systemUsers.setLastName(createUserRequest.getLastName());
		systemUsers.setMiddleName(createUserRequest.getMiddleName());
		systemUsers.setNamePrefixMasterid(namePrefixMaster.get());
		systemUsers.setEmail(createUserRequest.getEmail());
		systemUsers.setMobileNumber(createUserRequest.getMobileNumber());
		systemUsers.setRoleId(role.get());
		systemUsersrepository.save(systemUsers);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(systemUsers.getId());
		loginResponse.setStatusText("SUCCESS");
		loginResponse.setMessage("User created successfully");
		LOGGER.info("create user method ends..!");
		return loginResponse;

	}

	public LoginResponse editUserDetails(EditUserDetailsRequest editUserDetailsRequest, Roles role) {
		LOGGER.info("edit user details method started..!");

		Optional<SystemUsers> sysUser = systemUsersrepository.findById(editUserDetailsRequest.getUserId());
		if (!sysUser.isPresent()) {
			throw new NoRecordFoundException("Organization not found with Id " + editUserDetailsRequest.getUserId());
		}

		Optional<SystemUsers> systemUserEntity = systemUsersrepository.findById(editUserDetailsRequest.getId());
		if (!systemUserEntity.isPresent()) {
			throw new NoRecordFoundException("User not found with id " + editUserDetailsRequest.getId());
		}
		if (systemUserEntity.get().getOrganzationId().getId() != sysUser.get().getOrganzationId().getId()) {
			throw new InValidInputException("this user does not belong to same organization");
		}

		SystemUsers user = systemUserEntity.get();
		user.setUpdatedAt(LocalDateTime.now());
		user.setFirstName(editUserDetailsRequest.getFirstName());
		user.setLastName(editUserDetailsRequest.getLastName());
		user.setMiddleName(editUserDetailsRequest.getMiddleName());
		user.setEmail(editUserDetailsRequest.getEmail());
		user.setMobileNumber(editUserDetailsRequest.getMobileNumber());
		user.setRoleId(role);
		systemUsersrepository.save(user);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(editUserDetailsRequest.getId());
		loginResponse.setStatusText("SUCCESS");
		loginResponse.setMessage("User updated successfully");
		LOGGER.info("edit user details method ends..!");
		return loginResponse;

	}

	public ViewResponse searchUsers(SearchUsersRequest searchUsersRequest) {

		List<SearchUserDetailsResponse> viewUserDetailsResponseList = new ArrayList<>();

		String userFirstName = searchUsersRequest.getFirstName();
		String userLastName = searchUsersRequest.getLastName();

		Long roleId = searchUsersRequest.getRoleId();
		if (roleId == 0) {
			roleId = -999l;
		}

		String mobileNumber = searchUsersRequest.getMobileNumber();
		String email = searchUsersRequest.getEmail();

		Object[][] userDetails = systemUsersrepository.getUserDetails(userFirstName, userFirstName, userLastName,
				userLastName, mobileNumber, mobileNumber, email, email, roleId, roleId);

		for (Object[] objects : userDetails) {

			SearchUserDetailsResponse searchUserDetailsResponse = new SearchUserDetailsResponse();

			searchUserDetailsResponse.setId(((BigInteger) objects[0]).longValue());
			searchUserDetailsResponse.setName(((String) objects[1]));
			searchUserDetailsResponse.setEmail((String) objects[2]);
			searchUserDetailsResponse.setMobileNumber((String) objects[3]);
			searchUserDetailsResponse.setRole((String) objects[4]);
			viewUserDetailsResponseList.add(searchUserDetailsResponse);

		}

		ViewResponse response = new ViewResponse();
		response.setStatusText("success");
		response.setMessage("user details fetched successfully");
		response.setData(viewUserDetailsResponseList);

		return response;

	}

}
