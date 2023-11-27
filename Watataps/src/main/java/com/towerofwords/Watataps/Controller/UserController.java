package com.towerofwords.Watataps.Controller;

import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//UserController.java
@RestController
@RequestMapping("/watataps/users")
public class UserController {

 private final UserService userService;

 @Autowired
 public UserController(UserService userService) {
     this.userService = userService;
 }

 @GetMapping("/getAllUsers")
 public List<UserEntity> getAllUsers() {
     return userService.getAllUsers();
 }

 @GetMapping("/getUserById/{userId}")
 public UserEntity getUserById(@PathVariable int userId) {
     return userService.getUserById(userId);
 }

 @PostMapping("/createUser")
 public UserEntity createUser(@RequestBody UserEntity user) {
     return userService.createUser(user);
 }

 @PutMapping("/updateUser/{userId}")
 public UserEntity updateUser(@PathVariable int userId, @RequestBody UserEntity updatedUser) {
     return userService.updateUser(userId, updatedUser);
 }

 @DeleteMapping("/deleteUser/{userId}")
 public void deleteUser(@PathVariable int userId) {
     userService.deleteUser(userId);
 }
}