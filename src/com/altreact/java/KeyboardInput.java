package com.altreact.java;

import java.util.Scanner;

class KeyboardInput extends SimplerOutput {

    private static Scanner keyboardInput = new Scanner(System.in);

    private String userPromptMessage;
    private int lowestAcceptableValue;
    private int highestAcceptableValue;

    void setUserPromptMessage(String userPromptMessage) {
       this.userPromptMessage = userPromptMessage;
    }

    void setLowestAcceptableValue(int lowestAcceptableValue) {
        this.lowestAcceptableValue = lowestAcceptableValue;
    }

    void setHighestAcceptableValue(int highestAcceptableValue) {
        this.highestAcceptableValue = highestAcceptableValue;
    }

    int getValueWithinConstraints() {
        int value;
        do {
            output(userPromptMessage);
            value = getUserInputInteger();
            outputEmptyLine();
        } while (value < lowestAcceptableValue || value > highestAcceptableValue);
        return value;
    }

    private int getUserInputInteger() {
        return getIntegerFromString(getUserInputString());
    }

    private static int getIntegerFromString(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 99;
        }
    }

    private String getUserInputString() {
        return keyboardInput.nextLine();
    }
}
