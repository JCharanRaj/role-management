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
			throw new InValidInputException("Please enter First name");
		}

		if (createUserRequest.getLastName().isEmpty()) {
			throw new InValidInputException("Please enter Last name");
		}

		if (createUserRequest.getEmail().isEmpty()) {
			throw new InValidInputException("Please enter Email");
		}

		if (createUserRequest.getMobileNumber().isEmpty()) {
			throw new InValidInputException("Please enter Mobile Number");
		}
		return createUserService.createUser(createUserRequest);

	}

}
