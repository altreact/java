package com.altreact.greedy;

import com.altreact.greedy.input.Keyboard;
import com.altreact.greedy.output.ScreenOutput;
import static com.altreact.greedy.output.SimplerOutput.*;

public class Greedy {

    private static char currency = '$';
    private static String[] coinName = {"dollar", "half dollar", "quarter", "dime", "nickel", "penny"};
    private static String userInputPrompt = "Enter the amount of money you need change for: " + currency;
    private static double amountToMakeChangeFor = 0;
    private static int[] countForEachCoinValueInChange;

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        CoinCalculator coinCalculator = new CoinCalculator();
        ScreenOutput.displayProgramNameAndDescription();
        amountToMakeChangeFor = Keyboard.getAmountToMakeChangeFor(userInputPrompt);
        countForEachCoinValueInChange = coinCalculator.calculateNumberOfCoinsForEachCoinValue(amountToMakeChangeFor);
        outputTotalNumberOfCoinsInChange();
    }

    private static void outputTotalNumberOfCoinsInChange() {

        int lastCoinInList = countForEachCoinValueInChange.length;
        int totalNumberOfCoinsInChange = 0;

        outputLine("There are:");

        for (int thisCoin = 0; thisCoin < lastCoinInList; thisCoin++) {

            if (countForEachCoinValueInChange[thisCoin] != 0) {

                ScreenOutput.printCoinAmount(coinName[thisCoin], countForEachCoinValueInChange[thisCoin]);
                totalNumberOfCoinsInChange += countForEachCoinValueInChange[thisCoin];
            }
        }

        outputEmptyLine();
        outputEmptyLine();
        System.out.printf(" For a total of %d coins,", totalNumberOfCoinsInChange);
        outputEmptyLine();
        outputEmptyLine();
        System.out.printf(" in " + currency + "%.2f.", amountToMakeChangeFor);
        outputEmptyLine();
    }
}
