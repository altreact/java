package com.altreact.greedy.output;

import static com.altreact.greedy.output.SimplerOutput.*;

public class ScreenOutput {

    public static void displayProgramNameAndDescription() {

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

    public static void printCoinAmount(String coinName, int totalNumberOfCoinInChange) {

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
