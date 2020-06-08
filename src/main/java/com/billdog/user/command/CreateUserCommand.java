package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.exception.InValidInputException;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class CreateUserCommand implements Command<CreateUserRequest, LoginResponse> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public LoginResponse excute(CreateUserRequest createUserRequest) {

		if (createUserRequest.getFirstName().isEmpty()) {
			throw new InValidInputException("First Name should not be empty");
		}

		if (createUserRequest.getLastName().isEmpty()) {
			throw new InValidInputException("last Name should not be empty");
		}

		if (createUserRequest.getEmail().isEmpty()) {
			throw new InValidInputException("email should not be empty");
		}

		if (createUserRequest.getMobileNumber().isEmpty()) {
			throw new InValidInputException("mobile number should not be empty");
		}
		return createUserService.createUser(createUserRequest);

	}

}
