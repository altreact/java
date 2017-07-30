package com.altreact.greedy.input;

import com.altreact.greedy.UserInputPrompts;

import static com.altreact.greedy.output.SimplerOutput.*;

import java.util.Scanner;

public class Keyboard {

    private static Scanner keyboardInput = new Scanner(System.in);

    public static double getUserImputedValueToMakeChangeFor(String userInputPrompt) {

        double value;

        do {
            output(userInputPrompt);
            value = getUserInputDouble();
            outputEmptyLine();
        } while (value < 0);
        return value;
    }

    private static double getUserInputDouble() {
        return getDoubleFromString(getUserInputString());
    }

    private static double getDoubleFromString(String value) {

        double val;

        try {
            val = Double.valueOf(value);
        } catch (NumberFormatException e) {
            val = -1.00;
        }
        return val;
    }

    private static String getUserInputString() {
        return keyboardInput.nextLine();
    }
}
