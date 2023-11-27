package com.towerofwords.Watataps.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.ItemEntity;
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

    public UserEntity createUser(UserEntity user) {
        UserDetailsEntity userDetails = new UserDetailsEntity();
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

        return userRepository.save(user);
    }

}
