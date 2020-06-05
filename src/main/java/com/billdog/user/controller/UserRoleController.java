package com.billdog.user.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billdog.user.request.CreateRole;
import com.billdog.user.view.ViewResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserRoleController {
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/addMember", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> login(@RequestBody CreateRole createRole) {
		
		return null;
	}


}
