package com.altreact.java.output.pyramid.options;

import com.altreact.java.Pyramid;
import com.altreact.java.input.User;
import static com.altreact.java.output.System.*;

public class File extends User implements Option {

    @Override
    public void pyramidOutputStrategy(Pyramid pyramid) {
        setPyramidOutputToFile();
        pyramid.outputPyramid();
        confirmFileOutput();
    }

    private static void confirmFileOutput() {
        setOutputToScreen();
        confirmOutputToFile();
    }

    private static void setPyramidOutputToFile() {
        setFileOutputPrintStream();
    }

    private static void setOutputToScreen() {
        setConsolePrintStream();
    }

    private static void confirmOutputToFile() {
        output("Mario pyramid has been written to MarioPyramid.txt");
    }
}
