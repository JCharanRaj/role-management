package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.response.CreateUserResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class CreateUserCommand implements Command<CreateUserRequest, ResponseEntity<CreateUserResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<CreateUserResponse> excute(CreateUserRequest createUserRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(createUserService.createUser(createUserRequest));

	}

}
