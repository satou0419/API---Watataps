package com.towerofwords.Watataps.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.UserDetailsEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Repository.UserRepository;

@Service
public class UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
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
}