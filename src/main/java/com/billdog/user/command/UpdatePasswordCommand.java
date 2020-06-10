package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.UpdatePasswordRequest;
import com.billdog.user.response.UpdateUserDetailsResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class UpdatePasswordCommand
		implements Command<UpdatePasswordRequest, ResponseEntity<UpdateUserDetailsResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<UpdateUserDetailsResponse> excute(UpdatePasswordRequest updatePasswordRequest) {
		return createUserService.updatePassword(updatePasswordRequest);

	}
}
