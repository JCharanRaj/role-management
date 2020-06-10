package com.billdog.user.command;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.Organization;
import com.billdog.user.entity.Roles;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class EditUserDetailsCommand implements Command<EditUserDetailsRequest, LoginResponse> {

	@Autowired
	CreateUserService createUserService;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public LoginResponse excute(EditUserDetailsRequest editUserDetailsRequest) {

		Optional<Organization> organization = organizationRepository.findById(editUserDetailsRequest.getUserId());
		if (!organization.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.USER_NOT_FOUND + editUserDetailsRequest.getUserId());
		}

		Optional<Roles> role = rolesRepository.findById(editUserDetailsRequest.getRoleId());
		if (!role.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.ROLE_NOT_FOUND + editUserDetailsRequest.getRoleId());
		}
		return createUserService.editUserDetails(editUserDetailsRequest);

	}

}
