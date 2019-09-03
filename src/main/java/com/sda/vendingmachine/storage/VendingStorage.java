package com.sda.vendingmachine.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor         //constructor cu parametrii
@NoArgsConstructor
public class VendingStorage {

    Map<Integer, Queue<Item>> storageMap;

    @Override
    public String toString() {
        String toReturn = "";

        for (Map.Entry<Integer, Queue<Item>> entry : storageMap.entrySet()) {
            toReturn += "\n" + "Item details " + "\n" + "KeyPad number: " + entry.getKey() +
                    entry.getValue().peek().toString() + "Quantity: " + entry.getValue().size() + "\n";
        }
        return toReturn;
    }
}
