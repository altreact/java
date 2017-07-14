package com.altreact.java.input;

public class User extends com.altreact.java.Pyramid {

    protected static int getUserSelectedNumberOfRows() {

        Keyboard numberOfRows = getUserNumberOfRowsSelection();
        return userSelection(numberOfRows);

    }

    protected static int getUserSelectedOutputOption(){

        Keyboard pyramidOutputOption = getUserPyramidOutputOptionSelection();
        return userSelection(pyramidOutputOption);
    }

    private static int userSelection(Keyboard selection) {
        return selection.getValueWithinConstraints();
    }

    private static Keyboard getUserNumberOfRowsSelection() {

        String userPromptMessage = "\n# must be between 0 - 23\nEnter height of Mario User: ";
        return getSelection(userPromptMessage, 23, 0);
    }

    private static Keyboard getUserPyramidOutputOptionSelection() {

        String userPromptMessage = "\nOutput options:\n  1) to print to console\n  2) to write to file (MarioPyramid.txt)\n\nEnter output option: ";
        return getSelection(userPromptMessage, 2, 1);
    }

    private static Keyboard getSelection(String userPromptMessage, int highestAcceptableValue, int lowestAcceptableValue) {

        Keyboard selection = new Keyboard();

        selection.setUserPromptMessage(userPromptMessage);
        selection.setHighestAcceptableValue(highestAcceptableValue);
        selection.setLowestAcceptableValue(lowestAcceptableValue);

        return selection;
    }
}
