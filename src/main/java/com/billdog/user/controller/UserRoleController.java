package com.billdog.user.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.billdog.user.command.CreateUserCommand;
import com.billdog.user.command.EditUserDetailsCommand;
import com.billdog.user.command.SearchUsersCommand;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.request.SearchUsersRequest;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.view.ViewResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class UserRoleController {

	@Autowired
	CreateUserCommand createUserCommand;

	@Autowired
	EditUserDetailsCommand editUserDetailsCommand;

	@Autowired
	SearchUsersCommand searchUsersCommand;

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/addRole", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> login(@RequestBody CreateRoleRequest createRole) {

		return null;
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user created successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LoginResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
		return createUserCommand.excute(createUserRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user updated successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PutMapping(value = "/editUserDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LoginResponse editUserDetails(@RequestBody EditUserDetailsRequest editUserDetailsRequest) {
		return editUserDetailsCommand.excute(editUserDetailsRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user details fetched successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/searchUserDetails", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ViewResponse searchUsers(@RequestBody SearchUsersRequest searchUsersRequest) {
		return searchUsersCommand.excute(searchUsersRequest);
	}

}
