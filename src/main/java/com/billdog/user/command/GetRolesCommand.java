package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.service.GetRoleService;
import com.billdog.user.view.ViewResponse;

@Service
public class GetRolesCommand implements Command<Long, ResponseEntity<ViewResponse>> {

	@Autowired
	GetRoleService getRoleService;

	@Override
	public ResponseEntity<ViewResponse> excute(Long userId) {

		return getRoleService.getRoles(userId);
	}
}