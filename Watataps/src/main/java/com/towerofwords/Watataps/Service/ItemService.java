package com.towerofwords.Watataps.Service;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public ItemEntity addItem(ItemEntity item) {
        // Logic to add an item
        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public ItemEntity getItemById(int itemId) {
        // Retrieve an item by its ID
        Optional<ItemEntity> itemOptional = itemRepository.findById(itemId);
        return itemOptional.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<ItemEntity> getAllItems() {
        // Retrieve all items
        return itemRepository.findAll();
    }

    @Transactional
    public ItemEntity updateItem(ItemEntity newItem) {
        // Check if the item with the given ID exists in the database
        Optional<ItemEntity> existingItemOptional = itemRepository.findById(newItem.getItemID());

        if (existingItemOptional.isPresent()) {
            ItemEntity existingItem = existingItemOptional.get();

            // Update only the fields that are provided in the request
            if (newItem.getImagePath() != null) {
                existingItem.setImagePath(newItem.getImagePath());
            }
            if (newItem.getItemName() != null) {
                existingItem.setItemName(newItem.getItemName());
            }

            // Save and return the updated item
            return itemRepository.save(existingItem);
        } else {
            // Item with the given ID not found, you can handle this scenario accordingly
            return null; // or throw an exception, return a specific response, etc.
        }
    }

    @Transactional
    public void deleteItem(int itemId) {
        // Logic to delete an item
        itemRepository.deleteById(itemId);
    }
}