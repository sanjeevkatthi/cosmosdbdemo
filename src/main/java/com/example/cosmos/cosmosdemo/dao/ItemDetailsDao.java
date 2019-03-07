package com.example.cosmos.cosmosdemo.dao;

import com.example.cosmos.cosmosdemo.vo.ItemDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nisum on 05-03-2019.
 */
@Repository
public interface ItemDetailsDao extends MongoRepository<ItemDetails,Integer> {
}
