package com.altreact.java.output;

import com.altreact.java.input.User;

public class PreContext extends User {

    private static int userSelectedPyramidOutputOption;

    static void outputPyramidToScreen() {
        outputPyramid();
    }

    static void outputPyramidToFile() {
        setPyramidOutputToFile();
        outputPyramid();
        confirmFileOutput();
    }

    private static void confirmFileOutput() {
        setOutputToScreen();
        confirmOutputToFile();
    }

    protected static void letUserSelectNumberOfRowsInPyramid() {
        numberOfRows = userSelectedNumberOfRows();
    }

    protected static void letUserSelectPyramidOutputOption() {
        userSelectedPyramidOutputOption = getUserSelectedOutputOption();
    }

    static boolean pyramidOutputToFileWasChosenByUser() {
        return userSelectedPyramidOutputOption == 2;
    }

    private static void setPyramidOutputToFile() {
        System.setFileOutputPrintStream();
    }

    private static void setOutputToScreen() {
        System.setConsolePrintStream();
    }

    private static void confirmOutputToFile() {
        output("Mario pyramid has been written to MarioPyramid.txt");
    }

    private static int userSelectedNumberOfRows() {
        return getUserSelectedNumberOfRows();
    }
}
