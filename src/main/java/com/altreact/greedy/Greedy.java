package com.altreact.greedy;

import static com.altreact.greedy.SimpleOutput.*;

public class Greedy {

    private static double initialMoneyAmount = 4.97;
    private static int moneyAmount = decimalToInt(initialMoneyAmount);

    private static int totalNumberOfCoins = 0;

    final private static int dollar = 100;
    final private static int quarter = 25;
    final private static int dime = 10;
    final private static int nickel = 5;
    final private static int penny = 1;

    private static int numberOfDollars = 0;
    private static int numberOfQuarters = 0;
    private static int numberOfDimes = 0;
    private static int numberOfNickels = 0;
    private static int numberOfPennies = 0;

    public static void main(String[] args) {
        displayMainMessage();
        // get user imputed double
            // save user inputted double as moneyAmount
        deductCoinsFromMoneyAmount();
        outputTotalNumberOfCoins();
    }

    private static void displayMainMessage() {

        outputEmptyLine();
        outputLine("Greedy");
        outputLine("Mah Bois!");
        outputEmptyLine();
    }

    private static void deductCoinsFromMoneyAmount() {

        numberOfDollars = deductFromMoneyAmmountBy(dollar);
        numberOfQuarters = deductFromMoneyAmmountBy(quarter);
        numberOfDimes = deductFromMoneyAmmountBy(dime);
        numberOfNickels = deductFromMoneyAmmountBy(nickel);
        numberOfPennies = deductFromMoneyAmmountBy(penny);
        totalNumberOfCoins = getTotalNumberOfCoins();
    }

    private static int deductFromMoneyAmmountBy(int amountToDeduct) {

        int numberOfCoins = 0;

        while (moneyAmount - amountToDeduct >= 0) {

            moneyAmount = moneyAmount - amountToDeduct;
            numberOfCoins++;
        }
        return numberOfCoins;
    }

    private static int getTotalNumberOfCoins() {
        return numberOfDollars + numberOfQuarters + numberOfDimes + numberOfNickels + numberOfPennies;
    }

    private static void outputTotalNumberOfCoins() {

        outputEmptyLine();
        outputLine("there are:\n");
        System.out.printf("    %d dollars,\n", numberOfDollars);
        System.out.printf("    %d quarters,\n", numberOfQuarters);
        System.out.printf("    %d dimes,\n", numberOfDimes);
        System.out.printf("    %d nickels,\n", numberOfNickels);
        System.out.printf("    %d pennies,\n\n", numberOfPennies);
        System.out.printf(" for a total of %d coins in %f.\n", totalNumberOfCoins, initialMoneyAmount);
        outputEmptyLine();
    }

    private static int decimalToInt(double decimal) {
        return (int) (decimal * 100);
    }
}
