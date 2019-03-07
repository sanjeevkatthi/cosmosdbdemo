package com.example.cosmos.cosmosdemo.service;

import com.example.cosmos.cosmosdemo.dao.ItemDetailsDao;
import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.mapper.ItemDetailsMapper;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Nisum on 07-03-2019.
 */
public class ItemDetailsServiceImplTest {

    @Mock
    ItemDetailsDao itemDetailsDao;

    @InjectMocks
    ItemDetailsServiceImpl itemDetailsService;

    @Mock
    ItemDetailsMapper itemDetailsMapper;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getItemDetails() throws Exception {

        Optional<ItemDetails> itemDetailsOptional = Optional.of(buildItemDetails());
        Mockito.when(itemDetailsDao.findById(Mockito.anyInt())).thenReturn(itemDetailsOptional);
        Integer inputItemId = Integer.valueOf(1);

       Optional<ItemDetails> itemDetails = itemDetailsService.getItemDetails(inputItemId);
       assertNotNull(itemDetails);
       assertTrue(itemDetails.isPresent());
       assertEquals(inputItemId,itemDetails.get().getId());

    }

    @Test
    public void saveItemDetails() throws Exception {

        Item item = buildItem();
        ItemDetails itemDetails = buildItemDetails();
        Mockito.when(itemDetailsDao.save(Mockito.any(ItemDetails.class))).thenReturn(itemDetails);
        Mockito.when(itemDetailsMapper.mapItemDetailsToItem(Mockito.any(ItemDetails.class))).thenReturn(item);
        Mockito.when(itemDetailsMapper.mapItemToItemDetails(Mockito.any(Item.class))).thenReturn(itemDetails);
        Item savedItem = itemDetailsService.saveItemDetails(item);
        assertNotNull(savedItem);
        assertEquals(item.getId(),savedItem.getId());
    }

    @Test
    public void deleteItemDetails() throws Exception {

        Mockito.doNothing().when(itemDetailsDao).deleteById(Mockito.anyInt());
        itemDetailsService.deleteItemDetails(1);
    }

    private ItemDetails buildItemDetails() {
        ItemDetails item = new ItemDetails(1,"OnePlus6T","One plus 6T mobile");
        return item;
    }

    private Item buildItem() {
        Item item = new Item(1,"OnePlus6T","One plus 6T mobile");
        return item;
    }

}