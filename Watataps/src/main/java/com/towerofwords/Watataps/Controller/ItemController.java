package com.towerofwords.Watataps.Controller;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ItemEntity addItem(@RequestBody ItemEntity item) {
        return itemService.addItem(item);
    }

    @GetMapping("/getItem/{itemId}")
    public ItemEntity getItemById(@PathVariable int itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping("/getAllItems")
    public List<ItemEntity> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/updateItem")
    public ItemEntity updateItem(@RequestBody ItemEntity newItem) {
        return itemService.updateItem(newItem);
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public void deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
    }
}