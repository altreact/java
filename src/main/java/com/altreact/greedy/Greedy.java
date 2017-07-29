package com.altreact.greedy;

import com.altreact.greedy.input.Keyboard;
import static com.altreact.greedy.output.SimplerOutput.*;

public class Greedy {

    private static double amountChangeIsNeededFor;
    private static int amountLeftToMakeChangeFor;

    final private static int dollar = 100;
    final private static int halfDollar = 50;
    final private static int quarter = 25;
    final private static int dime = 10;
    final private static int nickel = 5;
    final private static int penny = 1;

    private static int numberOfDollars = 0;
    private static int numberOfHalfDollars = 0;
    private static int numberOfQuarters = 0;
    private static int numberOfDimes = 0;
    private static int numberOfNickels = 0;
    private static int numberOfPennies = 0;
    private static int totalNumberOfCoins = 0;

    // use arrays to clean up the following functions //////////////////////////////////////////////////////////////////

    private static void deductCoinsFromAmountChangeIsNeededFor() {

        numberOfDollars = deductFromMoneyAmountBy(dollar);
        numberOfHalfDollars = deductFromMoneyAmountBy(halfDollar);
        numberOfQuarters = deductFromMoneyAmountBy(quarter);
        numberOfDimes = deductFromMoneyAmountBy(dime);
        numberOfNickels = deductFromMoneyAmountBy(nickel);
        numberOfPennies = deductFromMoneyAmountBy(penny);
        totalNumberOfCoins = getTotalNumberOfCoins();
    }

    private static void outputTotalNumberOfCoinsInChange() {

        outputEmptyLine();
        outputLine("there are:\n");

        printCoinAmount("dollar", numberOfDollars);
        printCoinAmount("half dollar", numberOfHalfDollars);
        printCoinAmount("quarter", numberOfQuarters);
        printCoinAmount("dime", numberOfDimes);
        printCoinAmount("nickel", numberOfNickels);
        printCoinAmount("penny", numberOfPennies);

        System.out.printf("\n for a total of %d coins in %.2f.\n", totalNumberOfCoins, amountChangeIsNeededFor);
        outputEmptyLine();
    }

    private static int getTotalNumberOfCoins() {

        return numberOfDollars + numberOfHalfDollars +
                numberOfQuarters + numberOfDimes +
                numberOfNickels + numberOfPennies;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        start();
    }

    private static void displayProgramNameAndDescription() {

        outputEmptyLine();
        outputLine("Greedy :");
        outputEmptyLine();
        outputLine("outputs least number of coins in change for amount X");
        outputEmptyLine();
        outputLine("*****************************************************");
        outputEmptyLine();
    }

    private static void start() {

        displayProgramNameAndDescription();
        getUserImputedAmountChangeIsNeededFor();
        deductCoinsFromAmountChangeIsNeededFor();
        outputTotalNumberOfCoinsInChange();
    }

    private static void getUserImputedAmountChangeIsNeededFor() {

        double userImputedAmountChangeIsNeededFor = Keyboard.getUserImputedValueToMakeChangeFor();
        amountChangeIsNeededFor = roundDecimalDownToNearestHundredthsPlace(userImputedAmountChangeIsNeededFor);
        amountLeftToMakeChangeFor = decimalToInt(amountChangeIsNeededFor);
    }

    private static int deductFromMoneyAmountBy(int amountToDeduct) {

        int numberOfCoins = 0;

        while (amountLeftToMakeChangeFor - amountToDeduct >= 0) {

            amountLeftToMakeChangeFor -= amountToDeduct;
            numberOfCoins++;
        }

        return numberOfCoins;
    }

    private static void printCoinAmount(String coinName, int totalNumberOfCoinInChange) {

        if (totalNumberOfCoinInChange != 1) {

            int lengthOfCoinName = coinName.length();
            char lastLetterOfCoinName = coinName.charAt(lengthOfCoinName - 1);

            if (lastLetterOfCoinName != 'y') {
                coinName += "s";
            } else {

                String coinNameMinusTheTrailingLetterY = coinName.substring(0,  lengthOfCoinName- 1);

                coinName = coinNameMinusTheTrailingLetterY + "ies";
            }
        }

        String coinMessage = "    %d " + coinName + ",\n";

        System.out.printf(coinMessage, totalNumberOfCoinInChange);
    }

    private static int decimalToInt(double decimal) {
        return (int) (decimal * 100);
    }

    private static double roundDecimalDownToNearestHundredthsPlace(double decimal) {

        return 0.01 * Math.floor(decimal * 100.0);
    }
}
