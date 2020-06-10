package com.billdog.user.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billdog.user.command.CreateNavigationScreenCommand;
import com.billdog.user.command.CreateRoleCommand;
import com.billdog.user.command.CreateUserCommand;
import com.billdog.user.command.EditUserDetailsCommand;
import com.billdog.user.command.GetRoleScreensCommand;
import com.billdog.user.command.GetRolesCommand;
import com.billdog.user.command.SearchUsersCommand;
import com.billdog.user.exception.ErrorResponse;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.request.GetRoleScreens;
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
	CreateNavigationScreenCommand createNavigationScreenCommand;	

	@Autowired
	CreateRoleCommand createRoleCommand;
	
	@Autowired
	GetRolesCommand getRolesCommand;
	
	@Autowired
	GetRoleScreensCommand getRoleScreensCommand;

	@Autowired
	SearchUsersCommand searchUsersCommand;

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Role created successfully..!"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createRole(@Valid @RequestBody CreateRoleRequest createRole) {

		return createRoleCommand.excute(createRole);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Roles are fetched successfully..!"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@GetMapping(value = "/{userId}/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getRoles(@PathVariable long userId) {

		return getRolesCommand.excute(userId);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = ViewResponse.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = ErrorResponse.class, message = "Invalid parameters") })
	@PostMapping(value = "/navigationscreens", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getRoleScreens(@Valid @RequestBody GetRoleScreens getRoleScreens) {

		return getRoleScreensCommand.excute(getRoleScreens);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user created successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LoginResponse createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
		return createUserCommand.excute(createUserRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user updated successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PutMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LoginResponse editUserDetails(@Valid @RequestBody EditUserDetailsRequest editUserDetailsRequest) {
		return editUserDetailsCommand.excute(editUserDetailsRequest);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user created successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/navigationScreen", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createNavigationScreen(@Valid @RequestBody CreateNavigationScreen createNavigationScreen) {
		return createNavigationScreenCommand.excute(createNavigationScreen);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user details fetched successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/searchUserDetails", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ViewResponse searchUsers(@RequestBody SearchUsersRequest searchUsersRequest) {
		return searchUsersCommand.excute(searchUsersRequest);
	}

}
