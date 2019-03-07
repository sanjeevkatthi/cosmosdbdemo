package com.example.cosmos.cosmosdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Nisum on 07-03-2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    Integer id;
    String name;
    String description;
}
