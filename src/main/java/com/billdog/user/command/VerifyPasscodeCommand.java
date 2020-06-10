package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.VerifyPasscodeRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.service.CreateUserService;

@Service
public class VerifyPasscodeCommand implements Command<VerifyPasscodeRequest, ResponseEntity<LoginResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<LoginResponse> excute(VerifyPasscodeRequest verifyPasscodeRequest) {
		return createUserService.verifyPasscode(verifyPasscodeRequest);

	}
}
