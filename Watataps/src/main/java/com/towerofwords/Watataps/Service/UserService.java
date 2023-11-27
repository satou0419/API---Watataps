package com.towerofwords.Watataps.Service;

import com.towerofwords.Watataps.Entity.UserDetailsEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity createUser(UserEntity user) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setProgress(0);
        userDetails.setCredit(0);

        user.setUserDetails(userDetails);

        return userRepository.save(user);
    }
    
    public UserEntity getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Transactional
    public UserEntity updateUser(int userId, UserEntity updatedUser) {
        UserEntity existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update only the non-null fields
            if (updatedUser.getFirstname() != null) {
                existingUser.setFirstname(updatedUser.getFirstname());
            }
            if (updatedUser.getLastname() != null) {
                existingUser.setLastname(updatedUser.getLastname());
            }
            if (updatedUser.getUsername() != null) {
                existingUser.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            // Update only if the UserDetailsEntity is not null
            if (existingUser.getUserDetails() != null && updatedUser.getUserDetails() != null) {
                UserDetailsEntity existingDetails = existingUser.getUserDetails();
                UserDetailsEntity updatedDetails = updatedUser.getUserDetails();

                existingDetails.setProgress(updatedDetails.getProgress());
                existingDetails.setCredit(updatedDetails.getCredit());
            }

            return userRepository.save(existingUser);
        }

        return null; // or throw an exception
    }

    @Transactional
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}