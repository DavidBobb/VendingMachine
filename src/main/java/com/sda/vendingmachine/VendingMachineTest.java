package com.sda.vendingmachine;

import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {

    public static void main(String[] args) {

        Item heidiChocolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item stillWater = new Item(1, "Bucovina", BigDecimal.valueOf(2));
        Item cocaCola = new Item(1, "Coca Cola", BigDecimal.valueOf(3));

        Queue<Item> itemQueue = new ArrayDeque<Item>();

        itemQueue.add(heidiChocolate);
        itemQueue.add(stillWater);
        itemQueue.add(cocaCola);

        VendingStorage vendingStorage = new VendingStorage();
        Map<Integer, Queue<Item>> storageMap = vendingStorage.getStorageMap();

        storageMap.put(22, itemQueue);

    }
}
