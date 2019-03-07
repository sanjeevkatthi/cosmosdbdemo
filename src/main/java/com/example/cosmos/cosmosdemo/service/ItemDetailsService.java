package com.example.cosmos.cosmosdemo.service;

import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;

import java.util.Optional;

/**
 * Created by Nisum on 07-03-2019.
 */
public interface ItemDetailsService {

    Optional<ItemDetails> getItemDetails(Integer itemId);
    Item saveItemDetails(Item item);
    void deleteItemDetails(Integer itemId);
}
