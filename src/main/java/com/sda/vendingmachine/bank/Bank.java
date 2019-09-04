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
        double total = (pennyStack.size() * 0.01) + (nickelStack.size() * 0.05) + (dimeStack.size() * 0.10) +
                (halfStack.size() * 0.50) + (quarterStack.size() * 0.25) + (oneDollarStack.size() * 1);
        return "\n" + "Amount of money in the bank " +
                "\n" + "Penny: " + pennyStack.size() +
                "\n" + "Nickles: " + nickelStack.size() +
                "\n" + "Dimes: " + dimeStack.size() +
                "\n" + "Half: " + halfStack.size() +
                "\n" + "Quarters: " + quarterStack.size() +
                "\n" + "Dollars: " + oneDollarStack.size() +
                "\n" + "Total: " + total + "$";
    }

    public void updateBank(Queue<Coin> money) {
        for (Coin m : money) {
            switch (m) {
                case PENNY:
                    pennyStack.add(m);
                    break;
                case NICKEL:
                    nickelStack.add(m);
                    break;
                case DIME:
                    dimeStack.add(m);
                    break;
                case QUARTER:
                    quarterStack.add(m);
                    break;
                case HALF:
                    halfStack.add(m);
                    break;
                case ONE_DOLLAR:
                    oneDollarStack.add(m);
                    break;
            }
        }
    }
}
