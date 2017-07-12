package com.altreact.java.output;

import com.altreact.java.KeyboardInput;
import com.altreact.java.Pyramid;
import java.io.FileNotFoundException;

public class PyramidOutputOptions extends SimplerOutput {

    public static void outputPyramid() throws FileNotFoundException {

        Pyramid pyramid = new Pyramid();

        pyramid.setNumberOfRows(getUserSelectedNumberOfRows());

        if (getUserSelectedOutputOption() == 2) {
            SystemOutputOptions systemOutputOptions = new SystemOutputOptions();

            systemOutputOptions.setFileOutputStream();

            pyramid.outputPyramid();

            systemOutputOptions.setConsolePrintStream();

            output("Mario pyramid has been written to MarioPyramid.txt");

        } else {
            pyramid.outputPyramid();
        }
    }

    private static int getUserSelectedNumberOfRows() {

        KeyboardInput numberOfRows = getUserNumberOfRowsSelection();
        return userSelection(numberOfRows);

    }

    private static int getUserSelectedOutputOption(){

        KeyboardInput pyramidOutputOption = getUserPyramidOutputOptionSelection();
        return userSelection(pyramidOutputOption);
    }

    private static int userSelection(KeyboardInput selection) {
        return selection.getValueWithinConstraints();
    }

    private static KeyboardInput getUserNumberOfRowsSelection() {

        String userPromptMessage = "\n# must be between 0 - 23\nEnter height of Mario Pyramid: ";
        return getSelection(userPromptMessage, 23, 0);
    }

    private static KeyboardInput getUserPyramidOutputOptionSelection() {

        String userPromptMessage = "Enter:\n  1) to print to console\n  2) to write to file (MarioPyramid.txt)\n\n";
        return getSelection(userPromptMessage, 2, 1);
    }

    private static KeyboardInput getSelection(String userPromptMessage, int highestAcceptableValue, int lowestAcceptableValue) {

        KeyboardInput selection = new KeyboardInput();

        selection.setUserPromptMessage(userPromptMessage);
        selection.setHighestAcceptableValue(highestAcceptableValue);
        selection.setLowestAcceptableValue(lowestAcceptableValue);

        return selection;
    }
}
