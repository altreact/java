package com.altreact.greedy;

import static com.altreact.greedy.SimpleOutput.*;

public class Greedy {

    private static double moneyAmount = 4.95;
    private static double initialMoneyAmount = moneyAmount;

    private static int totalNumberOfCoins = 0;

    final private static double dollar = 1.00;
    final private static double quarter = 0.25;
    final private static double dime = 0.10;
    final private static double nickel = 0.05;
    final private static double penny = 0.01;

    private static int numberOfDollars = 0;
    private static int numberOfQuarters = 0;
    private static int numberOfDimes = 0;
    private static int numberOfNickels = 0;
    private static int numberOfPennies = 0;

    public static void main(String[] args) {
        displayMainMessage();
        // get user imputed double
            // save user inputted double as moneyAmount
        deductCoinsFromMoneyAmmount();
        outputTotalNumberOfCoins();
    }

    private static void displayMainMessage() {

        outputEmptyLine();
        outputLine("Greedy");
        outputLine("Mah Bois!");
        outputEmptyLine();
    }

    private static void deductCoinsFromMoneyAmmount() {

        numberOfDollars = deductFromMoneyAmmountBy(dollar);
        numberOfQuarters = deductFromMoneyAmmountBy(quarter);
        numberOfDimes = deductFromMoneyAmmountBy(dime);
        numberOfNickels = deductFromMoneyAmmountBy(nickel);
        numberOfPennies = deductFromMoneyAmmountBy(penny);
        totalNumberOfCoins = getTotalNumberOfCoins();
    }

    private static int deductFromMoneyAmmountBy(double amountToDeduct) {

        int numberOfCoins = 0;

        while (moneyAmount - amountToDeduct > 0) {
            moneyAmount = moneyAmount - amountToDeduct;
            System.out.println(moneyAmount);
            numberOfCoins++;
        }
        return numberOfCoins;
    }

    private static int getTotalNumberOfCoins() {
        return numberOfDollars + numberOfQuarters + numberOfDimes + numberOfNickels + numberOfPennies;
    }

    private static void outputTotalNumberOfCoins() {

        outputEmptyLine();
        outputLine("there are:");
        System.out.printf("    %d dollars,", numberOfDollars);
        System.out.printf("    %d quarters,", numberOfQuarters);
        System.out.printf("    %d dimes,", numberOfDimes);
        System.out.printf("    %d nickels,", numberOfNickels);
        System.out.printf("    %d pennies,", numberOfPennies);
        System.out.printf(" for a total of %d coins in %f.", totalNumberOfCoins, initialMoneyAmount);
        outputEmptyLine();
    }
}
