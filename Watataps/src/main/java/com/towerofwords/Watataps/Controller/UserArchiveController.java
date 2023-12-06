	package com.towerofwords.Watataps.Controller;
	
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.towerofwords.Watataps.Entity.UserArchiveEntity;
	import com.towerofwords.Watataps.Entity.UserEntity;
	import com.towerofwords.Watataps.Service.UserArchiveService;
	
	@RestController
	@RequestMapping("/watataps/user-archives")
	public class UserArchiveController {
	
	    private final UserArchiveService userArchiveService;
	
	    public UserArchiveController(UserArchiveService userArchiveService) {
	        this.userArchiveService = userArchiveService;
	    }
	
	    @PostMapping("/addWordToUserArchive/{userId}/{wordId}")
	    public ResponseEntity<UserEntity> addWordToUserArchive(@PathVariable int userId, @PathVariable int wordId) {
	        try {
	            UserEntity updatedUser = userArchiveService.addWordToUserArchive(userId, wordId);
	            
	            if (updatedUser != null) {
	                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or handle as appropriate
	            }
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("/getUserArchiveById/{userId}")
	    public ResponseEntity<UserArchiveEntity> getUserArchive(@PathVariable int userId) {
	        UserArchiveEntity userArchive = userArchiveService.getUserArchive(userId);
	
	        return userArchive != null
	                ? new ResponseEntity<>(userArchive, HttpStatus.OK)
	                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}