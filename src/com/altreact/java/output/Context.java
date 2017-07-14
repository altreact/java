package com.altreact.java.output;

public class Context <Pyramid> extends PreContext {

    protected static void outputMarioPyramid() {

        if (pyramidOutputToFileWasChosenByUser()) {
            outputPyramidToFile();
        } else {
            outputPyramidToScreen();
        }
    }
}
