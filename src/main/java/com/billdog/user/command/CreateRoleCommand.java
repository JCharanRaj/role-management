package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.service.CreateRoleService;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateRoleCommand implements Command<CreateRoleRequest, ResponseEntity<ViewResponse>> {

	@Autowired
	CreateRoleService createRoleService;

	@Override
	public ResponseEntity<ViewResponse> excute(CreateRoleRequest createRoleRequest) {

		return createRoleService.createRole(createRoleRequest);
	}
}
