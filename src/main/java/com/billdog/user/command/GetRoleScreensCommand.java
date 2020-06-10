package com.billdog.user.command;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.common.ExceptionalMessages;
import com.billdog.user.entity.Roles;
import com.billdog.user.entity.SystemUsers;
import com.billdog.user.exception.InValidInputException;
import com.billdog.user.exception.NoRecordFoundException;
import com.billdog.user.repository.RolesRepository;
import com.billdog.user.repository.SystemUsersrepository;
import com.billdog.user.request.GetRoleScreens;
import com.billdog.user.service.GetRoleService;
import com.billdog.user.view.ViewResponse;

@Service
public class GetRoleScreensCommand implements Command<GetRoleScreens, ResponseEntity<ViewResponse>> {

	@Autowired
	SystemUsersrepository systemUsersrepository;

	@Autowired
	GetRoleService getRoleService;

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public ResponseEntity<ViewResponse> excute(GetRoleScreens getRoleScreens) {

		Optional<SystemUsers> optional = systemUsersrepository.findById(getRoleScreens.getUserId());
		if (!optional.isPresent()) {
			throw new NoRecordFoundException(ExceptionalMessages.USER_NOT_FOUND + getRoleScreens.getUserId());
		}

		Optional<Roles> role = rolesRepository.findById(getRoleScreens.getRoleId());
		if (!role.isPresent()) {
			throw new InValidInputException(ExceptionalMessages.ROLE_NOT_FOUND+ + getRoleScreens.getRoleId());
		}
		return getRoleService.getRoleScreens(getRoleScreens,role.get());

	}
}
