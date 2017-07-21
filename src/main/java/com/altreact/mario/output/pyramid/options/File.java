package com.altreact.mario.output.pyramid.options;

import com.altreact.mario.Pyramid;
import com.altreact.mario.input.User;
import static com.altreact.mario.output.System.*;

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
