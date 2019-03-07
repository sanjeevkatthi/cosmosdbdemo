package com.example.cosmos.cosmosdemo.controller;

import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.service.ItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nisum on 06-03-2019.
 */
@RestController
@RequestMapping("/api/cosomos/")
public class ItemDetailsController {

    @Autowired
    private ItemDetailsService itemDetailsService;

    @GetMapping(value = "/items/{id}")
    public ResponseEntity getItemDetails(@PathVariable("id") Integer itemId) {

        return  ResponseEntity.ok(itemDetailsService.getItemDetails(itemId));
    }

    @PostMapping(value = "/items/")
    public ResponseEntity saveItemDetails(Item item) {
        Item savedItem;
        String message = "item is not saved";

            savedItem = itemDetailsService.saveItemDetails(item);
            if (savedItem !=null){
                message = "Item Saved Successfully";
            }

        return  ResponseEntity.ok(message);
    }

    @PutMapping(value = "/items/")
    public ResponseEntity updateItemDetails(Item item) {

        Item savedItem;
        String message = "item is not updated";
            savedItem = itemDetailsService.saveItemDetails(item);
            if (savedItem !=null){
                message = "Item updated Successfully";
            }
        return  ResponseEntity.ok(message);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity deleteItemDetails(@PathVariable("id") Integer itemId) {

             itemDetailsService.deleteItemDetails(itemId);

        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
