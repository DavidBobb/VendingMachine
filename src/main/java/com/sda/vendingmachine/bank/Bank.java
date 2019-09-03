package com.sda.vendingmachine.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    private Queue<Coin> pennyStack;
    private Queue<Coin> nickelStack;
    private Queue<Coin> dimeStack;
    private Queue<Coin> halfStack;
    private Queue<Coin> quarterStack;
    private Queue<Coin> oneDollarStack;

    @Override
    public String toString() {
        return "\n" + "Amount of money in the bank " +
                "\n" + "Penny: " + pennyStack.size() +
                "\n" + "Nickles: " + nickelStack.size() +
                "\n" + "Dimes: " + dimeStack.size() +
                "\n" + "Half: " + halfStack.size() +
                "\n" + "Quarters: " + quarterStack.size() +
                "\n" + "Dollars: " + oneDollarStack.size();
    }
}
