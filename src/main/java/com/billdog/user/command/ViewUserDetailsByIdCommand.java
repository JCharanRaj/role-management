package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.GetUserRequest;
import com.billdog.user.service.CreateUserService;
import com.billdog.user.view.ViewResponse;

@Service
public class ViewUserDetailsByIdCommand implements Command<GetUserRequest, ResponseEntity<ViewResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<ViewResponse> excute(GetUserRequest getUserRequest) {
		return createUserService.getUserById(getUserRequest);

	}

}
