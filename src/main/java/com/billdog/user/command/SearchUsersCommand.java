package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billdog.user.request.SearchUsersRequest;
import com.billdog.user.service.CreateUserService;
import com.billdog.user.view.ViewResponse;

@Service
public class SearchUsersCommand implements Command<SearchUsersRequest, ViewResponse> {

	@Autowired
	CreateUserService createUserService;

	@Override
	public ViewResponse excute(SearchUsersRequest SearchUsersRequest) {
		return createUserService.searchUsers(SearchUsersRequest);

	}
}