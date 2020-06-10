package com.billdog.user.service;

import java.math.BigInteger;
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
import com.billdog.user.response.CreateUserResponse;
import com.billdog.user.response.UpdateUserDetailsResponse;
import com.billdog.user.response.ViewUsersResponse;
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

	/**
	 * @param createUserRequest
	 * @return
	 */
	public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest) {
		LOGGER.info("create user method started..!");

		// This jpa query checks whether the organization is present or not from
		// systemUser table
		Optional<SystemUsers> sysUser = systemUsersrepository.findById(createUserRequest.getUserId());
		if (!sysUser.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + createUserRequest.getUserId());
		}

		// This jpa query checks whether the prefix is present or not from prefixMaster
		// table
		Optional<NamePrefixMaster> namePrefixMaster = namePrefixMasterRepository.findById(1l);
		if (!namePrefixMaster.isPresent()) {
			throw new NoRecordFoundException("Id not found with " + 1);
		}

		// This jpa query checks whether the role is present or not from roles table
		Optional<Roles> role = rolesRepository.findById(createUserRequest.getRoleId());
		if (!role.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.ROLE_NOT_FOUND + createUserRequest.getRoleId());
		}

		// entering into creating new user
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

		// providing successful response if user data is stores
		CreateUserResponse createUserResponse = new CreateUserResponse();
		createUserResponse.setId(systemUsers.getId());
		createUserResponse.setStatusText(Constants.SUCCESS);
		createUserResponse.setMessage(Constants.USER_CREATED);
		LOGGER.info("create user method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(createUserResponse);

	}

	/**
	 * @param editUserDetailsRequest
	 * @param role
	 * @return
	 */
	public ResponseEntity<UpdateUserDetailsResponse> updateUserDetails(EditUserDetailsRequest editUserDetailsRequest,
			Roles role) {
		LOGGER.info("edit user details method started..!");

		// This jpa query checks whether the organization is present or not from
		// systemUser table
		Optional<SystemUsers> sysUser = systemUsersrepository.findById(editUserDetailsRequest.getUserId());
		if (!sysUser.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + editUserDetailsRequest.getUserId());
		}

		// This jpa query checks whether the user is present or not from systemUser
		// table
		Optional<SystemUsers> systemUserEntity = systemUsersrepository.findById(editUserDetailsRequest.getId());
		if (!systemUserEntity.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + editUserDetailsRequest.getId());
		}

		// This condition checks whether the user's organization and updating user
		// organization is same or not from systemUser table
		if (systemUserEntity.get().getOrganzationId().getId() != sysUser.get().getOrganzationId().getId()) {
			throw new InValidInputException(ExceptionalMessages.THIS_USER_DOES_NOT_BELONG_TO_SAME_ORGANIZATION);
		}

		// entering into updating user as per request
		SystemUsers user = systemUserEntity.get();
		user.setUpdatedAt(LocalDateTime.now());
		user.setFirstName(editUserDetailsRequest.getFirstName());
		user.setLastName(editUserDetailsRequest.getLastName());
		user.setMiddleName(editUserDetailsRequest.getMiddleName());
		user.setEmail(editUserDetailsRequest.getEmail());
		user.setMobileNumber(editUserDetailsRequest.getMobileNumber());
		user.setRoleId(role);
		systemUsersrepository.save(user);

		// providing successful response if user data is stores
		UpdateUserDetailsResponse updateUserDetails = new UpdateUserDetailsResponse();
		updateUserDetails.setId(editUserDetailsRequest.getId());
		updateUserDetails.setStatusText(Constants.SUCCESS);
		updateUserDetails.setMessage(Constants.USER_UPDATED);
		LOGGER.info("edit user details method ends..!");
		return ResponseEntity.status(HttpStatus.OK).body(updateUserDetails);

	}

	/**
	 * @param searchUsersRequest
	 * @return
	 */
	public ResponseEntity<ViewResponse> searchUsers(SearchUsersRequest searchUsersRequest) {
		LOGGER.info("search user details method started..!");

		// creating arraylist for response class
		List<SearchUserDetailsResponse> viewUserDetailsResponseList = new ArrayList<>();

		String userFirstName = searchUsersRequest.getFirstName();
		String userLastName = searchUsersRequest.getLastName();

		Long roleId = searchUsersRequest.getRoleId();
		if (roleId == 0) {
			roleId = -999l;
		}

		String mobileNumber = searchUsersRequest.getMobileNumber();
		String email = searchUsersRequest.getEmail();

		// native query for searching users and assigning parameters respectively
		Object[][] userDetails = systemUsersrepository.getUserDetails(userFirstName, userFirstName, userLastName,
				userLastName, mobileNumber, mobileNumber, email, email, roleId, roleId);

		// for loop for users searched with native query and assigning values
		// respectively
		for (Object[] objects : userDetails) {

			SearchUserDetailsResponse searchUserDetailsResponse = new SearchUserDetailsResponse();

			searchUserDetailsResponse.setId(((BigInteger) objects[0]).longValue());
			searchUserDetailsResponse.setName(((String) objects[1]));
			searchUserDetailsResponse.setEmail((String) objects[2]);
			searchUserDetailsResponse.setMobileNumber((String) objects[3]);
			searchUserDetailsResponse.setRole((String) objects[4]);
			viewUserDetailsResponseList.add(searchUserDetailsResponse);

		}

		// providing successful response
		ViewResponse response = new ViewResponse();
		response.setStatusText(Constants.SUCCESS);
		response.setMessage(Constants.USER_DETAILS_FETCHED);
		response.setData(viewUserDetailsResponseList);

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	public ResponseEntity<ViewResponse> getUserById(Long userId) {
		LOGGER.info("edit user details method started..!");

		// This jpa query checks whether the organization is present or not from
		// systemUser table
		Optional<SystemUsers> sysUser = systemUsersrepository.findById(userId);
		if (!sysUser.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + userId);
		}

		// This jpa query checks whether the role is present or not from role table
		Optional<Roles> role = rolesRepository.findById(sysUser.get().getRoleId().getId());
		if (!role.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.ROLE_NOT_FOUND + sysUser.get().getRoleId().getId());
		}

		// entering into assigning values respectively
		ViewUsersResponse viewUsersResponse = new ViewUsersResponse();
		SystemUsers user = sysUser.get();
		viewUsersResponse.setFirstName(user.getFirstName());
		viewUsersResponse.setLastName(user.getLastName());
		viewUsersResponse.setMiddleName(user.getMiddleName());
		viewUsersResponse.setEmail(user.getEmail());
		viewUsersResponse.setMobileNumber(user.getMobileNumber());
		viewUsersResponse.setRole(role.get().getRole());
		viewUsersResponse.setId(user.getId());

		ViewResponse viewResponse = new ViewResponse();
		viewResponse.setStatusText(Constants.SUCCESS);
		viewResponse.setMessage(Constants.USER_DETAILS_FETCHED);
		viewResponse.setData(viewUsersResponse);
		return ResponseEntity.status(HttpStatus.OK).body(viewResponse);

	}

}
