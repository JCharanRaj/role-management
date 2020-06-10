package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.SearchUsersRequest;
import com.billdog.user.service.CreateUserService;
import com.billdog.user.view.ViewResponse;

@Service
public class SearchUsersCommand implements Command<SearchUsersRequest, ResponseEntity<ViewResponse>> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ResponseEntity<ViewResponse> excute(SearchUsersRequest SearchUsersRequest) {
		return createUserService.searchUsers(SearchUsersRequest);

	}
}