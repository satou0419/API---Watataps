package com.towerofwords.Watataps.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Entity.UserItemEntity;
import com.towerofwords.Watataps.Repository.ItemRepository;
import com.towerofwords.Watataps.Repository.UserItemRepository;
import com.towerofwords.Watataps.Repository.UserRepository;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final UserItemRepository userItemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, UserRepository userRepository, UserItemRepository userItemRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.userItemRepository = userItemRepository;
    }

    @Transactional
    public ItemEntity addItemWithUserItems(ItemEntity item) {
        ItemEntity savedItem = itemRepository.save(item);

        List<UserEntity> users = userRepository.findAll();
        for (UserEntity user : users) {
            UserItemEntity userItem = new UserItemEntity();
            userItem.setItem(savedItem);
            userItem.setUserDetails(user.getUserDetails());
            // Set other properties as needed
            userItemRepository.save(userItem);
        }

        return savedItem;
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(int itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
    
    @Transactional
    public ItemEntity updateItem(int itemId, ItemEntity updatedItem) {
        ItemEntity existingItem = itemRepository.findById(itemId).orElse(null);

        if (existingItem != null) {
            // Update only non-null fields
            if (updatedItem.getImagePath() != null) {
                existingItem.setImagePath(updatedItem.getImagePath());
            }
            if (updatedItem.getItemName() != null) {
                existingItem.setItemName(updatedItem.getItemName());
            }

            // You can add more fields to update based on your requirements

            return itemRepository.save(existingItem);
        }

        return null; // or throw an exception if needed
    }

    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
