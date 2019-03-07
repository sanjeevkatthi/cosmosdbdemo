package com.example.cosmos.cosmosdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Nisum on 05-03-2019.
 */
@Data
@Document(collection = "itemDetails")
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {

    Integer id;
    String name;
    String description;
}
