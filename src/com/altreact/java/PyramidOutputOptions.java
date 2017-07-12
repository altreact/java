package com.altreact.java;

class PyramidOutputOptions extends SimplerOutput {

    static void outputPyramid () {

        Pyramid pyramid = setPyramid();
        pyramid.outputPyramid();

    }

    private static Pyramid setPyramid() {

        Pyramid pyramid = new Pyramid();

        pyramid.setNumberOfRows(getUserSelectedNumberOfRows());

        // set to output to screen or file, based on user input
        outputLine(getUserSelectedOutputOption());

        return pyramid;
    }

    private static int getUserSelectedNumberOfRows() {

        KeyboardInput numberOfRows = getNumberOfRowsSelection();
        return userSelection(numberOfRows);

    }

    private static int getUserSelectedOutputOption(){

        KeyboardInput pyramidOutputOption = getPyramidOutputOptionSelection();
        return userSelection(pyramidOutputOption);
    }

    private static int userSelection(KeyboardInput selection) {
        return selection.getValueWithinConstraints();
    }

    private static KeyboardInput getNumberOfRowsSelection() {

        String userPromptMessage = "\n# must be between 0 - 23\nEnter height of Mario Pyramid: ";
        return getSelection(userPromptMessage, 23, 0);
    }

    private static KeyboardInput getPyramidOutputOptionSelection() {

        String userPromptMessage = "Enter:\n  1) to print to console\n  2) to write to file (Mario.txt)\n\n";
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
