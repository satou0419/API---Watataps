package com.towerofwords.Watataps.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Entity.UserDetailsEntity;
import com.towerofwords.Watataps.Service.UserService;
import com.towerofwords.Watataps.Service.UserDetailsService;

import java.util.List;

@RestController
@RequestMapping("/watataps/users")

public class UserController {
	
	

    private final UserService userService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }
    
    
    @GetMapping("/personalInformation/allUser")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    
    @GetMapping("/hello")
    public String hello() {
    	return "Hello";
    }

    @GetMapping("/personalInformationById/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int userId) {
        UserEntity user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/getAllUsersDetails")
    public ResponseEntity<List<UserDetailsEntity>> getAllUserDetails() {
        List<UserDetailsEntity> allUserDetails = userDetailsService.getAllUserDetails();
        return ResponseEntity.ok(allUserDetails);
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDetailsEntity> getUserDetailsById(@PathVariable int userId) {
        UserDetailsEntity userDetails = userDetailsService.getUserDetailsById(userId);
        if (userDetails != null) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int userId, @RequestBody UserEntity updatedUser) {
        UserEntity updatedUserEntity = userService.updateUser(userId, updatedUser);

        if (updatedUserEntity != null) {
            return ResponseEntity.ok(updatedUserEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
