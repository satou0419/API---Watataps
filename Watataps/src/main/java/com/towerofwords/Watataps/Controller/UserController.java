package com.towerofwords.Watataps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Service.UserService;

@RestController
@RequestMapping("/watataps/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/createUser")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}

}
