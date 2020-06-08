package com.billdog.user.service;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.billdog.user.entity.NavigationScreens;
import com.billdog.user.repository.NavigationScreensRepository;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.view.ViewResponse;

@Service
public class NavigationService {	

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NavigationService.class);
	
	@Audited
	NavigationScreensRepository navigationScreensRepository;
	
	
	public ViewResponse createNavigationPage(CreateNavigationScreen screen) {
		LOGGER.info("createNavigationPage method started..!");
		
		
		if(screen.getParentId()>0) {
			navigationScreensRepository.findById(screen.getParentId());
		}
		
		
		NavigationScreens navigationScreens=new NavigationScreens();
		navigationScreens.setCreatedAt(LocalDateTime.now());
		navigationScreens.setUpdatedAt(LocalDateTime.now());
		
		LOGGER.info("createNavigationPage method ends..!");
		return null;
		
	}
	
	

}
