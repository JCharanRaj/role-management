package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class CreateUserCommand implements Command<CreateUserRequest, LoginResponse> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public LoginResponse excute(CreateUserRequest createUserRequest) {

		return createUserService.createUser(createUserRequest);

	}

}
