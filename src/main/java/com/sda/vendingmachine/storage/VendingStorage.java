package com.sda.vendingmachine.storage;

import lombok.Data;

import java.util.Map;
import java.util.Queue;

@Data
public class VendingStorage {

    Map<Integer, Queue<Item>> storageMap;




}
