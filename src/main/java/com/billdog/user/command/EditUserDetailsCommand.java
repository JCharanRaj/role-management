package com.billdog.user.command;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.Organization;
import com.billdog.user.entity.Roles;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.response.UpdateUserDetailsResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class EditUserDetailsCommand implements Command<EditUserDetailsRequest, ResponseEntity<UpdateUserDetailsResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Override
	public ResponseEntity<UpdateUserDetailsResponse> excute(EditUserDetailsRequest editUserDetailsRequest) {

		Optional<Organization> organization = organizationRepository.findById(editUserDetailsRequest.getUserId());
		if (!organization.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + editUserDetailsRequest.getUserId());
		}
		Optional<Roles> role = rolesRepository.findById(editUserDetailsRequest.getRoleId());
		if (!role.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.ROLE_NOT_FOUND + editUserDetailsRequest.getRoleId());
		}
		return createUserService.updateUserDetails(editUserDetailsRequest, role.get());

	}

}
