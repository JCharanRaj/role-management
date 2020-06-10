package com.billdog.user.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.exception.InValidInputException;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.service.NavigationService;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateNavigationScreenCommand implements Command<CreateNavigationScreen, ResponseEntity<ViewResponse>> {

	@Autowired
	NavigationService navigationService;

	@Override
	public ResponseEntity<ViewResponse> excute(CreateNavigationScreen createNavigationScreen) {

		return navigationService.createNavigationPage(createNavigationScreen);
	}

}
