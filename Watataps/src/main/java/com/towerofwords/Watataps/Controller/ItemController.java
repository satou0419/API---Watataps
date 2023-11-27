package com.towerofwords.Watataps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.towerofwords.Watataps.Entity.ItemEntity;
import com.towerofwords.Watataps.Service.ItemService;

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
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
