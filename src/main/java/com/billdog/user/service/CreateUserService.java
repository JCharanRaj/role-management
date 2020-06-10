package com.billdog.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.NamePrefixMaster;
import com.billdog.user.entity.Organization;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.repository.NamePrefixMasterRepository;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.response.LoginResponse;

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

		Optional<Organization> organization = organizationRepository.findById(createUserRequest.getUserId());
		if (!organization.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.USER_NOT_FOUND + createUserRequest.getUserId());
		}
		Optional<NamePrefixMaster> namePrefixMaster = namePrefixMasterRepository.findById((long) 1);
		if (!namePrefixMaster.isPresent()) {
			throw new InValidInputException("Id not found with " + 1);
		}

		Optional<Roles> role = rolesRepository.findById(createUserRequest.getRoleId());
		if (!role.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.ROLE_NOT_FOUND+ createUserRequest.getRoleId());
		}

		SystemUsers systemUsers = new SystemUsers();
		systemUsers.setCreatedAt(LocalDateTime.now());
		systemUsers.setUpdatedAt(LocalDateTime.now());
		systemUsers.setOrgansationId(organization.get());
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

	public LoginResponse editUserDetails(EditUserDetailsRequest editUserDetailsRequest) {
		LOGGER.info("edit user details method started..!");

		Optional<SystemUsers> systemUserEntity = systemUsersrepository.findById(editUserDetailsRequest.getId());
		if (!systemUserEntity.isPresent()) {
			throw new InValidInputException("User not found with id " + editUserDetailsRequest.getId());
		}

		SystemUsers user = systemUserEntity.get();
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setFirstName(editUserDetailsRequest.getFirstName());
		user.setLastName(editUserDetailsRequest.getLastName());
		user.setMiddleName(editUserDetailsRequest.getMiddleName());
		user.setEmail(editUserDetailsRequest.getEmail());
		user.setMobileNumber(editUserDetailsRequest.getMobileNumber());
		systemUsersrepository.save(user);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(editUserDetailsRequest.getId());
		loginResponse.setStatusText("SUCCESS");
		loginResponse.setMessage("User updated successfully");
		LOGGER.info("edit user details method ends..!");
		return loginResponse;

	}

//	public ViewResponse searchUsers(SearchUsersRequest searchUsersRequest) {
//
//		List<SearchUserDetailsResponse> viewUserDetailsResponseList = new ArrayList<>();
//
//		Object[][] userDetails = systemUsersrepository.getUserDetails(searchRequest.getName(), searchRequest.getName());
//
//		for (Object[] objects : userDetails) {
//
//			SearchUserDetailsResponse searchUserDetailsResponse = new SearchUserDetailsResponse();
//
//			viewStudentDetails.setAddress((String) objects[0]);
//			viewStudentDetails.setAddress1((String) objects[1]);
//			viewStudentDetails.setBranch((String) objects[2]);
//			viewStudentDetails.setCity((String) objects[3]);
//			viewStudentDetails.setEmail((String) objects[4]);
//			viewStudentDetails.setFatherName((String) objects[5]);
//			viewStudentDetails.setName((String) objects[6]);
//			viewStudentDetails.setNumber((String) objects[7]);
//			viewStudentDetails.setRollNumber((String) objects[8]);
//			viewStudentDetails.setState((String) objects[9]);
//			viewStudentDetailsList.add(viewStudentDetails);
//
//		}
//
//		StudentView response = new StudentView();
//		response.setStatus("success");
//		response.setData(viewStudentDetailsList);
//
//		return response;
//
//	}

}
