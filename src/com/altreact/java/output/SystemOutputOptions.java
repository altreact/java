package com.altreact.java.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

class SystemOutputOptions extends SimplerOutput {

    private PrintStream consolePrintStream;
    private PrintStream filePrintStream;

    SystemOutputOptions() {
        this.consolePrintStream = System.out;
        this.filePrintStream = getFilePrintStream();
    }

    void setFileOutputStream() {
        setPrintStreamTo(filePrintStream);
    }

    void setConsolePrintStream() {
        setPrintStreamTo(consolePrintStream);
    }

    private PrintStream getFilePrintStream() {

        try {
            File outputFile = new File("MarioPyramid.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            return new PrintStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            output("trouble finding file: " + e.getMessage());
            return consolePrintStream;
        }
    }

    private void setPrintStreamTo(PrintStream printStream) {
        System.setOut(printStream);
    }
}
