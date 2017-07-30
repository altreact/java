package com.altreact.greedy;

import com.altreact.greedy.input.Keyboard;
import static com.altreact.greedy.output.SimplerOutput.*;

public class Greedy {

    private static String[] nameOfEachCoin = {"dollar", "half dollar", "quarter", "dime", "nickel", "penny"};
    private static int[] coinValueOfEachCoin = {100, 50, 25, 10, 5, 1};
    private static int[] coinCountForEachCoin = {0, 0, 0, 0, 0, 0};
    private static double amountToMakeChangeFor;
    private static int amountLeftToMakeChangeFor;
    private static int totalNumberOfCoins = 0;
    private static char currency = '$';

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        displayProgramNameAndDescription();
        getUserImputedAmountChangeIsNeededFor();
        MakeChange();
        outputTotalNumberOfCoinsInChange();
    }

    private static void displayProgramNameAndDescription() {

        outputEmptyLine();
        outputLine("********************************************************************************");
        outputEmptyLine();
        outputLine("Greedy :");
        outputEmptyLine();
        outputLine("outputs change for given amount, using the least number of coins as possible");
        outputEmptyLine();
        outputLine("********************************************************************************");
        outputEmptyLine();
    }

    private static void getUserImputedAmountChangeIsNeededFor() {

        double userImputedAmountChangeIsNeededFor = Keyboard.getUserImputedValueToMakeChangeFor();
        amountToMakeChangeFor = roundDecimalDownToNearestHundredthsPlace(userImputedAmountChangeIsNeededFor);
        amountLeftToMakeChangeFor = convertDoubleIntoInteger(amountToMakeChangeFor);
    }

    private static int convertDoubleIntoInteger(double decimal) {
        return (int) (decimal * 100);
    }

    private static double roundDecimalDownToNearestHundredthsPlace(double decimal) {

        return 0.01 * Math.floor(decimal * 100.0);
    }

    private static void MakeChange() {

        int lastCoinInListOfCoins = coinValueOfEachCoin.length;

        for (int thisCoin = 0; thisCoin != lastCoinInListOfCoins; thisCoin++) {
            coinCountForEachCoin[thisCoin] = getMaxCoinCountOfThisCoinForChange(coinValueOfEachCoin[thisCoin]);
        }

        totalNumberOfCoins = getTotalNumberOfCoins();
    }

    private static int getMaxCoinCountOfThisCoinForChange(int valueOfThisCoin) {

        int numberOfThisCoinInTotalChange = 0;

        while (amountLeftToMakeChangeFor - valueOfThisCoin >= 0) {
            amountLeftToMakeChangeFor -= valueOfThisCoin;
            numberOfThisCoinInTotalChange++;
        }

        return numberOfThisCoinInTotalChange;
    }

    private static int getTotalNumberOfCoins() {

        int totalCoinCountInChange = 0;

        for (int numberOfThisCoinInChange : coinCountForEachCoin) {
            totalCoinCountInChange += numberOfThisCoinInChange;
        }

        return totalCoinCountInChange;
    }

    private static void outputTotalNumberOfCoinsInChange() {

        outputLine("There are:");

        int lastCoinInList = coinCountForEachCoin.length;

        for (int thisCoin = 0; thisCoin < lastCoinInList; thisCoin++) {
            printCoinAmount(nameOfEachCoin[thisCoin], coinCountForEachCoin[thisCoin]);
        }

        outputEmptyLine();
        outputEmptyLine();
        System.out.printf(" For a total of %d coins,", totalNumberOfCoins);
        outputEmptyLine();
        outputEmptyLine();
        System.out.printf(" in " + currency + "%.2f.", amountToMakeChangeFor);
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

        String coinMessage = "    %d " + coinName + ",";
        outputEmptyLine();
        System.out.printf(coinMessage, totalNumberOfCoinInChange);
    }
}
