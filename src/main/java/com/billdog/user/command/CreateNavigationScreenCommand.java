package com.billdog.user.command;

import org.hibernate.envers.Audited;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.service.UserNavigationService;
import com.billdog.user.view.ViewResponse;

@Service
public class CreateNavigationScreenCommand implements Command<CreateNavigationScreen, ResponseEntity<ViewResponse>>{

	@Audited
	UserNavigationService navigationService;
	
	@Override
	public ResponseEntity<ViewResponse> excute(CreateNavigationScreen request) {
		
		
		return navigationService.createNavigationPage(request);
	}

}
