package com.altreact.greedy;

import com.altreact.greedy.input.Keyboard;
import static com.altreact.greedy.output.SimplerOutput.*;

public class Greedy {

    private static int[] coinValues = {100, 50, 25, 10, 5, 1};
    private static String[] coinNames = {"dollar", "half dollar", "quarter", "dime", "nickel", "penny"};
    private static int[] coinCount = {0, 0, 0, 0, 0, 0};
    private static double amountChangeIsNeededFor;
    private static int amountLeftToMakeChangeFor;
    private static int totalNumberOfCoins = 0;

    public static void main(String[] args) {

        start();
    }

    private static void start() {

        displayProgramNameAndDescription();
        getUserImputedAmountChangeIsNeededFor();
        deductCoinsFromAmountChangeIsNeededFor();
        outputTotalNumberOfCoinsInChange();
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

    private static void getUserImputedAmountChangeIsNeededFor() {

        double userImputedAmountChangeIsNeededFor = Keyboard.getUserImputedValueToMakeChangeFor();
        amountChangeIsNeededFor = roundDecimalDownToNearestHundredthsPlace(userImputedAmountChangeIsNeededFor);
        amountLeftToMakeChangeFor = decimalToInt(amountChangeIsNeededFor);
    }

    private static int decimalToInt(double decimal) {
        return (int) (decimal * 100);
    }

    private static double roundDecimalDownToNearestHundredthsPlace(double decimal) {

        return 0.01 * Math.floor(decimal * 100.0);
    }

    private static int deductFromAmountToMakeChangeFor(int amountToDeduct) {

        int numberOfCoins = 0;

        while (amountLeftToMakeChangeFor - amountToDeduct >= 0) {
            amountLeftToMakeChangeFor -= amountToDeduct;
            numberOfCoins++;
        }

        return numberOfCoins;
    }

    private static void deductCoinsFromAmountChangeIsNeededFor() {

        for (int x = 0; x < coinCount.length; x++) {
            coinCount[x] = deductFromAmountToMakeChangeFor(coinValues[x]);
        }

        totalNumberOfCoins = getTotalNumberOfCoins();
    }

    private static int getTotalNumberOfCoins() {

        int totalCoinCount = 0;

        for (int coinAmount : coinCount) {
            totalCoinCount += coinAmount;
        }

        return totalCoinCount;
    }

    private static void outputTotalNumberOfCoinsInChange() {

        outputEmptyLine();
        outputLine("there are:\n");

        for (int x = 0; x < coinCount.length; x++) {
            printCoinAmount(coinNames[x], coinCount[x]);
        }

        System.out.printf("\n for a total of %d coins in %.2f.\n", totalNumberOfCoins, amountChangeIsNeededFor);
        outputEmptyLine();
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
}
