package com.cubex.survey.v1.controllers;

import com.cubex.survey.v1.dto.ApiResponse;
import com.cubex.survey.v1.dto.SignupDTO;
import com.cubex.survey.v1.dto.UpdateUserDTO;
import com.cubex.survey.v1.models.User;
import com.cubex.survey.v1.services.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User Controller", description = "User Controller")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "Create a new user")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@RequestBody SignupDTO dto) {
        User user = new User(dto.getNames(), dto.getEmail(), dto.getProfileImage(), dto.getPassword());
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/create").toUriString());
        return ResponseEntity.created(uri).body(new ApiResponse(true, "User created successfully", this.userService.createUser(user)));
    }

    @ApiOperation(value = "Get a user")
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(new ApiResponse(true, "User fetched successfully", this.userService.getUserById(id)));
    }

    @ApiOperation(value = "Update a user")
    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable(value = "id") int id, @RequestBody UpdateUserDTO dto) {
        User user = this.userService.getUserById(id);
        user.setNames(dto.getNames());
        user.setEmail(dto.getEmail());
        user.setProfileImage(dto.getProfileImage());
        return ResponseEntity.ok().body(new ApiResponse(true, "User updated successfully", this.userService.updateUser(user)));
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "id") int id) {
        this.userService.deleteUser(id);
        return ResponseEntity.ok().body(new ApiResponse(true, "User deleted successfully", null));
    }

    @ApiOperation(value = "Get user by survey id")
    @GetMapping("/survey/{id}")
    public ResponseEntity<ApiResponse> getUserBySurveyId(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(new ApiResponse(true, "User fetched successfully", this.userService.getUserBySurveyId(id)));
    }


}

