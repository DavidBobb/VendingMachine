package com.sda.vendingmachine.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data                       //gettere si settere
@AllArgsConstructor         //constructor cu parametrii
@NoArgsConstructor          //constructor default
public class Item {

    private int id;
    private String name;
    private BigDecimal price;
}
