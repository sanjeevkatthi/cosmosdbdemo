package com.example.cosmos.cosmosdemo.service;

import com.example.cosmos.cosmosdemo.dao.ItemDetailsDao;
import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.exception.ItemDetailsException;
import com.example.cosmos.cosmosdemo.mapper.ItemDetailsMapper;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Nisum on 07-03-2019.
 */
@Service
public class ItemDetailsServiceImpl implements ItemDetailsService {

    @Autowired
    ItemDetailsMapper itemDetailsMapper;

    @Autowired
    private ItemDetailsDao itemDetailsDao;

    @Override
    public Optional<ItemDetails> getItemDetails(Integer itemId) {
        Optional<ItemDetails> itemDetails = Optional.empty();
        try {
            itemDetails = itemDetailsDao.findById(itemId);

        } catch (Exception e) {
            throw new ItemDetailsException("unexpected error occured while retrieving item details", e);
        }
        return itemDetails;
    }

    @Override
    public Item saveItemDetails(Item item) {
        ItemDetails itemDetails;

        try {
            itemDetails = itemDetailsMapper.mapItemToItemDetails(item);
            ItemDetails savedItem = itemDetailsDao.save(itemDetails);
            if (null != savedItem) {
                item = itemDetailsMapper.mapItemDetailsToItem(itemDetails);
            }
        } catch (Exception e) {
            throw new ItemDetailsException("unexpected error occured while saving item details", e);
        }

        return item;
    }

    @Override
    public void deleteItemDetails(Integer itemId) {

        try {
            itemDetailsDao.deleteById(itemId);

        } catch (Exception e) {
            throw new ItemDetailsException("unexpected error occured while deleting the item details", e);
        }
    }
}
