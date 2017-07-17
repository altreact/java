package com.altreact.java.output.pyramid;

import com.altreact.java.input.User;
import com.altreact.java.output.pyramid.options.*;
import com.altreact.java.Pyramid;

public class Context extends User {

    private static Option userSelectedOutputOption;
    private static Pyramid pyramid = new Pyramid();
    private static int userSelectedPyramidOutputOption;

    protected static void outputMarioPyramid() {
        letUserChooseOutputOptions();
        setPyramidOutputOption();
        outputPyramid();
    }

    private static void letUserChooseOutputOptions() {
        letUserSelectNumberOfRowsInPyramid();
        letUserSelectPyramidOutputOption();
    }

    private static void setPyramidOutputOption() {
        if (pyramidOutputToFileWasChosenByUser()) {
            userSelectedOutputOption = new File();
        } else {
            userSelectedOutputOption = new Screen();
        }
    }

    private static void outputPyramid() {
        userSelectedOutputOption.pyramidOutputStrategy(pyramid);
    }

    private static void letUserSelectNumberOfRowsInPyramid() {
        pyramid.setNumberOfRows(userSelectedNumberOfRows());
    }

    private static void letUserSelectPyramidOutputOption() {
        userSelectedPyramidOutputOption = getUserSelectedOutputOption();
    }

    private static boolean pyramidOutputToFileWasChosenByUser() {
        return userSelectedPyramidOutputOption == 2;
    }

    private static int userSelectedNumberOfRows() {
        return getUserSelectedNumberOfRows();
    }
}
