package com.towerofwords.Watataps.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Entity.UserArchiveEntity;
import com.towerofwords.Watataps.Entity.UserDetailsEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Entity.UserItemEntity;
import com.towerofwords.Watataps.Repository.ItemRepository;
import com.towerofwords.Watataps.Repository.UserDetailsRepository;
import com.towerofwords.Watataps.Repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private ItemRepository itemEntityRepository;
    
    
    
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(int userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }
    
    public UserEntity createUser(UserEntity user) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        UserArchiveEntity userArchive = new UserArchiveEntity();
        userDetails.setProgress(0);
        userDetails.setCredit(0);

        List<ItemEntity> items = itemEntityRepository.findAll();
        List<UserItemEntity> userItems = new ArrayList<>();

        for (ItemEntity item : items) {
            UserItemEntity userItemEntity = new UserItemEntity();
            userItemEntity.setUserDetails(userDetails);
            userItemEntity.setItem(item);
            userItemEntity.setQuantity(0);
            userItems.add(userItemEntity);
        }

        userDetails.setUserItems(userItems);
        user.setUserDetails(userDetails);

        // Initialize an empty list of words in the UserArchiveEntity
        userArchive.setWords(new ArrayList<>());

        user.setUserArchive(userArchive);

        // Save the user entity
        UserEntity savedUser = userRepository.save(user);

        return savedUser;
    }

    
    @Transactional
    public UserEntity updateUser(int userId, UserEntity updatedUser) {
        UserEntity existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update only non-null fields
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

            // You can add more fields to update based on your requirements

            return userRepository.save(existingUser);
        }

        return null; // or throw an exception if needed
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
