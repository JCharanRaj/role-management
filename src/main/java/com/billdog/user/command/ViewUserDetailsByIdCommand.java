package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.service.CreateUserService;
import com.billdog.user.view.ViewResponse;

@Service
public class ViewUserDetailsByIdCommand implements Command<Long, ResponseEntity<ViewResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<ViewResponse> excute(Long userId) {
		return createUserService.getUserById(userId);

	}

}
