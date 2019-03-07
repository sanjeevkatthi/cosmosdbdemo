package com.example.cosmos.cosmosdemo.mapper;

import com.example.cosmos.cosmosdemo.dto.Item;
import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.mapstruct.Mapper;

/**
 * Created by Nisum on 07-03-2019.
 */
@Mapper
public interface ItemDetailsMapper {
    ItemDetails mapItemToItemDetails(Item item);
    Item mapItemDetailsToItem(ItemDetails itemDetails);
}
