package com.billdog.user.command;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.entity.Roles;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.OrganizationRepository;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.response.UpdateUserDetailsResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class EditUserDetailsCommand implements Command<EditUserDetailsRequest, UpdateUserDetailsResponse> {

	@Autowired
	CreateUserService createUserService;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Override
	public UpdateUserDetailsResponse excute(EditUserDetailsRequest editUserDetailsRequest) {

		Optional<Roles> role = rolesRepository.findById(editUserDetailsRequest.getRoleId());
		if (!role.isPresent()) {
			throw new NoRecordFoundException("roleID not found with " + editUserDetailsRequest.getRoleId());
		}
		return createUserService.updateUserDetails(editUserDetailsRequest, role.get());

	}

}
