package com.altreact.java.output.pyramid;

import com.altreact.java.input.User;
import com.altreact.java.output.pyramid.options.*;
import com.altreact.java.Pyramid;

public class Context extends User {

    private static Option userSelectedOutputOption;
    private static Pyramid pyramid = new Pyramid();
    private static int userSelectedPyramidOutputOption;

    protected static void outputMarioPyramid() {
        letUserSelectNumberOfRowsInPyramid();
        letUserSelectPyramidOutputOption();
        setPyramidOutputOption();
        outputPyramid();
    }

    private static void letUserSelectNumberOfRowsInPyramid() {
        pyramid.setNumberOfRows(userSelectedNumberOfRows());
    }

    private static int userSelectedNumberOfRows() {
        return getUserSelectedNumberOfRows();
    }

    private static void letUserSelectPyramidOutputOption() {
        userSelectedPyramidOutputOption = getUserSelectedOutputOption();
    }

    private static void setPyramidOutputOption() {
        if (pyramidOutputToFileWasChosenByUser()) {
            userSelectedOutputOption = PyramidOutput.toFile();
        } else {
            userSelectedOutputOption = PyramidOutput.toScreen();
        }
    }

    private static boolean pyramidOutputToFileWasChosenByUser() {
        return userSelectedPyramidOutputOption == 2;
    }

    private static void outputPyramid() {
        userSelectedOutputOption.pyramidOutputStrategy(pyramid);
    }
}
