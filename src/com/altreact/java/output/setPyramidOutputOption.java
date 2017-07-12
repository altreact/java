package com.altreact.java.output;

public class setPyramidOutputOption extends PyramidOutputOptions {

    private static int userSelectedPyramidOutputOption;

    protected static void pyramidOut() {

        letUserSelectNumberOfRowsInPyramid();
        letUserSelectPyramidOutputOption();

        if (pyramidOutputToFileWasChosenByUser()) {
            outputPyramidToFile();
        } else {
            outputPyramidToScreen();
        }
    }

    private static void outputPyramidToScreen() {
        outputPyramid();
    }

    private static void outputPyramidToFile() {
        setPyramidOutputToFile();
        outputPyramid();
        confirmFileOutput();
    }

    private static void confirmFileOutput() {
        setOutputToScreen();
        confirmOutputToFile();
    }

    private static void letUserSelectNumberOfRowsInPyramid() {
        numberOfRows = userSelectedNumberOfRows();
    }

    private static void letUserSelectPyramidOutputOption() {
        userSelectedPyramidOutputOption = getUserSelectedOutputOption();
    }

    private static boolean pyramidOutputToFileWasChosenByUser() {
        return userSelectedPyramidOutputOption == 2;
    }

    private static void setPyramidOutputToFile() {
        SystemOutputOptions.setFileOutputPrintStream();
    }

    private static void setOutputToScreen() {
        SystemOutputOptions.setConsolePrintStream();
    }

    private static void confirmOutputToFile() {
        output("Mario pyramid has been written to MarioPyramid.txt");
    }

    private static int userSelectedNumberOfRows() {
        return getUserSelectedNumberOfRows();
    }
}
