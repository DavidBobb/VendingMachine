package com.sda.vendingmachine.implementation;

import com.sda.vendingmachine.bank.Bank;
import com.sda.vendingmachine.bank.Coin;
import com.sda.vendingmachine.exceptions.NotSufficientChangeException;
import com.sda.vendingmachine.exceptions.SoldOutException;
import com.sda.vendingmachine.storage.Item;
import com.sda.vendingmachine.storage.VendingStorage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendingMachineImpl implements IVendingMachine {

    private VendingStorage storage;
    private Bank bank;

    public Item getItem(int productCode) {

        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);

        if (queueByProductCode == null || queueByProductCode.size() == 0) {
            throw new SoldOutException("The product is sold out!");
        } else {
            return queueByProductCode.poll();
        }

    }

    public void payItem(int productCode, Queue<Coin> amountPayed) {

        Map<Integer, Queue<Item>> myStorageMap = storage.getStorageMap();

        Queue<Item> queueByProductCode = myStorageMap.get(productCode);

        BigDecimal amountExpected = queueByProductCode.peek().getPrice();

        BigDecimal amountPayedAsBigDecimal = getTotalMoneyAsBigDecimal(amountPayed);

        if (amountPayedAsBigDecimal.compareTo(amountExpected) < 0) {
            throw new NotSufficientChangeException("Insufficient funds");
        } else {
            bank.updateBank(amountPayed);
        }


    }

    public Queue<Coin> getChange(BigDecimal amountExpected, BigDecimal amountReceived) {
        return null;

    }

    public void cancelRequest() {

    }

    public BigDecimal getTotalMoneyAsBigDecimal(Queue<Coin> money) {
        BigDecimal total = BigDecimal.ZERO;
        for (Coin m : money) {
            switch (m) {
                case PENNY:
                    total = total.add(BigDecimal.valueOf(0.01));
                    break;
                case NICKEL:
                    total = total.add(BigDecimal.valueOf(0.05));
                    break;
                case DIME:
                    total = total.add(BigDecimal.valueOf(0.10));
                    break;
                case QUARTER:
                    total = total.add(BigDecimal.valueOf(0.25));
                    break;
                case HALF:
                    total = total.add(BigDecimal.valueOf(0.50));
                    break;
                case ONE_DOLLAR:
                    total = total.add(BigDecimal.valueOf(1));
                    break;
            }
        }
        return total;
    }

}
