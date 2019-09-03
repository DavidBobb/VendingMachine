package com.sda.vendingmachine;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.implementation.VendingMachineImpl;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VendingMachineTest {

    public static void main(String[] args) {

        Item heidiChocolate = new Item(1, "Ciocolata Heidi", BigDecimal.valueOf(5));
        Item mineralWater = new Item(2, "Mineral Water", BigDecimal.valueOf(7));
        Item cocaCola = new Item(3, "Coca Cola", BigDecimal.valueOf(10));

        Queue<Item> chocolateItemQueue = new ArrayDeque<>();
        chocolateItemQueue.add(heidiChocolate);
        chocolateItemQueue.add(heidiChocolate);
        chocolateItemQueue.add(heidiChocolate);
        chocolateItemQueue.add(heidiChocolate);

        Queue<Item> waterItemQueue = new ArrayDeque<>();
        waterItemQueue.add(mineralWater);
        waterItemQueue.add(mineralWater);
        waterItemQueue.add(mineralWater);
        waterItemQueue.add(mineralWater);
        waterItemQueue.add(mineralWater);
        waterItemQueue.add(mineralWater);

        Queue<Item> colaItemQueue = new ArrayDeque<>();
        colaItemQueue.add(cocaCola);
        colaItemQueue.add(cocaCola);
        colaItemQueue.add(cocaCola);
        colaItemQueue.add(cocaCola);
        colaItemQueue.add(cocaCola);

        Map<Integer, Queue<Item>> storageMap = new HashMap<>();
        storageMap.put(22, chocolateItemQueue);
        storageMap.put(23, waterItemQueue);
        storageMap.put(24, colaItemQueue);

        VendingStorage vendingStorage = new VendingStorage(storageMap);

        Bank bank = new Bank();
        Queue<Coin> oneDollars = new ArrayDeque<>();
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);
        oneDollars.add(Coin.ONE_DOLLAR);

        Queue<Coin> nickles = new ArrayDeque<>();
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);
        nickles.add(Coin.NICKEL);

        Queue<Coin> dimes = new ArrayDeque<>();
        dimes.add(Coin.DIME);
        dimes.add(Coin.DIME);
        dimes.add(Coin.DIME);
        dimes.add(Coin.DIME);
        dimes.add(Coin.DIME);

        Queue<Coin> half = new ArrayDeque<>();
        half.add(Coin.HALF);
        half.add(Coin.HALF);
        half.add(Coin.HALF);
        half.add(Coin.HALF);
        half.add(Coin.HALF);
        half.add(Coin.HALF);

        Queue<Coin> penny = new ArrayDeque<>();
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);
        penny.add(Coin.PENNY);

        bank.setOneDollarStack(oneDollars);
        bank.setDimeStack(dimes);
        bank.setHalfStack(half);
        bank.setPennyStack(penny);
        bank.setQuarterStack(new ArrayDeque<>());
        bank.setNickelStack(new ArrayDeque<>());

        System.out.println(bank);

        VendingMachineImpl iVendingMachine = new VendingMachineImpl();
        iVendingMachine.setStorage(vendingStorage);
        iVendingMachine.setBank(bank);

        iVendingMachine.getItem(22);
        System.out.println(vendingStorage);
    }
}
