package com.towerofwords.Watataps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/watataps/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<ItemEntity> addItem(@RequestBody ItemEntity item) {
        ItemEntity savedItem = itemService.addItemWithUserItems(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        List<ItemEntity> allItems = itemService.getAllItems();
        return ResponseEntity.ok(allItems);
    }

    @GetMapping("getItemById/{itemId}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable int itemId) {
        ItemEntity item = itemService.getItemById(itemId);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/updateItem/{itemId}")
    public ResponseEntity<ItemEntity> updateItem(@PathVariable int itemId, @RequestBody ItemEntity updatedItem) {
        ItemEntity updatedItemEntity = itemService.updateItem(itemId, updatedItem);

        if (updatedItemEntity != null) {
            return ResponseEntity.ok(updatedItemEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
