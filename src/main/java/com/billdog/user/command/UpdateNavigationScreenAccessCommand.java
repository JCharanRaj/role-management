package com.billdog.user.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.billdog.user.request.UpdateNavigationScreen;
import com.billdog.user.service.NavigationService;
import com.billdog.user.view.ViewResponse;

@Service
public class UpdateNavigationScreenAccessCommand implements Command<UpdateNavigationScreen, ResponseEntity<ViewResponse>>{

	@Autowired
	NavigationService navigationService;
	
	@Override
	public ResponseEntity<ViewResponse> excute(UpdateNavigationScreen request) {
		
		return navigationService.updateScreenAccess(request);
	}

}
