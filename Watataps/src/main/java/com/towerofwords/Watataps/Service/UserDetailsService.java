package com.towerofwords.Watataps.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.UserDetailsEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Repository.UserDetailsRepository;
import com.towerofwords.Watataps.Repository.UserRepository;

@Service
public class UserDetailsService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;


    @Autowired
    public UserDetailsService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;

    }

    @Transactional
    public UserEntity createUser(UserEntity user) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
        userDetails.setProgress(0);
        userDetails.setCredit(0);

        user.setUserDetails(userDetails);

        return userRepository.save(user);
    }
    
    public List<UserDetailsEntity> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }

    public UserDetailsEntity getUserDetailsById(int userId) {
        Optional<UserDetailsEntity> userDetailsOptional = userDetailsRepository.findById(userId);
        return userDetailsOptional.orElse(null);
    }
}