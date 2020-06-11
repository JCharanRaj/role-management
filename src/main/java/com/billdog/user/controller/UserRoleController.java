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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billdog.user.command.CreateNavigationScreenCommand;
import com.billdog.user.command.CreateRoleCommand;
import com.billdog.user.command.CreateUserCommand;
import com.billdog.user.command.EditUserDetailsCommand;
import com.billdog.user.command.GetRoleScreensCommand;
import com.billdog.user.command.GetRolesCommand;
import com.billdog.user.command.SearchUsersCommand;
import com.billdog.user.command.UpdateNavigationScreenAccessCommand;
import com.billdog.user.command.UpdatePasswordCommand;
import com.billdog.user.command.VerifyPasscodeCommand;
import com.billdog.user.command.ViewUserDetailsByIdCommand;
import com.billdog.user.request.CreateNavigationScreen;
import com.billdog.user.request.CreateRoleRequest;
import com.billdog.user.request.CreateUserRequest;
import com.billdog.user.request.EditUserDetailsRequest;
import com.billdog.user.request.GetRoleScreens;
import com.billdog.user.request.GetUserRequest;
import com.billdog.user.request.SearchUsersRequest;
import com.billdog.user.request.UpdateNavigationScreen;
import com.billdog.user.request.UpdatePasswordRequest;
import com.billdog.user.request.VerifyPasscodeRequest;
import com.billdog.user.response.CreateUserResponse;
import com.billdog.user.response.LoginResponse;
import com.billdog.user.response.UpdateUserDetailsResponse;
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

	@Autowired
	ViewUserDetailsByIdCommand viewUserDetailsByIdCommand;

	@Autowired
	VerifyPasscodeCommand verifyPasscodeCommand;

	@Autowired
	UpdatePasswordCommand updatePasswordCommand;

	@Autowired
	UpdateNavigationScreenAccessCommand updateNavigationScreenAccessCommand;

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createRole(@Valid @RequestBody CreateRoleRequest createRole) {

		return createRoleCommand.excute(createRole);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@GetMapping(value = "/{userId}/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getRoles(@PathVariable long userId) {

		return getRolesCommand.excute(userId);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@GetMapping(value = "/navigationscreens", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getRoleScreens(@RequestParam long userId, @RequestParam long roleId) {
		GetRoleScreens getRoleScreens = new GetRoleScreens();
		getRoleScreens.setRoleId(roleId);
		getRoleScreens.setUserId(userId);
		return getRoleScreensCommand.excute(getRoleScreens);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "Generate OTP"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PutMapping(value = "/navigationscreens", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> updateRoleScreenAccess(@Valid @RequestBody UpdateNavigationScreen request) {

		return updateNavigationScreenAccessCommand.excute(request);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user created successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {

		return createUserCommand.excute(createUserRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user updated successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UpdateUserDetailsResponse> editUserDetails(
			@Valid @RequestBody EditUserDetailsRequest editUserDetailsRequest) {
		return editUserDetailsCommand.excute(editUserDetailsRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user created successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/navigationScreen", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> createUserNavigation(
			@Valid @RequestBody CreateNavigationScreen createNavigationScreen) {
		return createNavigationScreenCommand.excute(createNavigationScreen);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "user details fetched successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/searchUsers", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> searchUsers(@RequestBody SearchUsersRequest searchUsersRequest) {
		return searchUsersCommand.excute(searchUsersRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "User details fetched successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@GetMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ViewResponse> getUser(@RequestParam long id, @RequestParam long userId) {
		GetUserRequest getUserRequest = new GetUserRequest();
		getUserRequest.setId(id);
		getUserRequest.setUserId(userId);
		return viewUserDetailsByIdCommand.excute(getUserRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "passcode verified successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PostMapping(value = "/verifyPasscode", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LoginResponse> verifyPasscode(
			@Valid @RequestBody VerifyPasscodeRequest verifyPasscodeRequest) {
		return verifyPasscodeCommand.excute(verifyPasscodeRequest);
	}

	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = Response.class, message = "password updated successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = Response.class, message = "Invalid parameters") })
	@PutMapping(value = "/updatePassword", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UpdateUserDetailsResponse> updatePassword(
			@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest) {
		return updatePasswordCommand.excute(updatePasswordRequest);
	}

}
