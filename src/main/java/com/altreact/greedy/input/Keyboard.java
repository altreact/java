package com.altreact.greedy.input;

import static com.altreact.greedy.output.SimplerOutput.*;
import com.altreact.greedy.output.UserInputPrompts;
import java.util.Scanner;

public class Keyboard {

    private static Scanner keyboardInput = new Scanner(System.in);

    public static double getUserInputedValueToMakeChangeFor() {

        double value;

        do {
            output(UserInputPrompts.valueToMakeChangeFor);
            value = getUserInputDouble();
            outputEmptyLine();
        } while (value >= 0);
        return value;
    }

    private static int getUserInputDouble() {
        return getDoubleFromString(getUserInputString());
    }

    private static int getDoubleFromString(String value) {

        int val;

        try {
            val = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            val = -1;
        }
        return val;
    }

    private static String getUserInputString() {
        return keyboardInput.nextLine();
    }
}
