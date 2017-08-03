package com.altreact.greedy.input;

import java.util.Scanner;
import static com.altreact.greedy.output.SimplerOutput.*;

public class Keyboard {

    public static double getAmountToMakeChangeFor(String userInputPrompt) {

        double number;

        do {
            output(userInputPrompt);
            number = getUserInputDouble();
            outputEmptyLine();
        } while (number < 0);

        return Converter.doubleToTwoPointPrecisionDouble(number);
    }

    private static double getUserInputDouble() {
        return Converter.stringToDouble(getUserInputString());
    }

    private static String getUserInputString() {
        return keyboardInput.nextLine();
    }

    private static Scanner keyboardInput = new Scanner(System.in);
}
