package com.altreact.java.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

class SystemOutputOptions extends SimplerOutput {

    private static PrintStream consolePrintStream;

    static void setFileOutputPrintStream() {
        PrintStream filePrintStream = getFilePrintStream();
        setPrintStreamTo(filePrintStream);
    }

    static void setConsolePrintStream() {
        setPrintStreamTo(consolePrintStream);
    }

    private static PrintStream getFilePrintStream() {

        PrintStream printStream;
        consolePrintStream = System.out;

        try {
            File outputFile = new File("MarioPyramid.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            printStream = new PrintStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            output("trouble finding file: " + e.getMessage());
            printStream = consolePrintStream;
        }
        return printStream;
    }

    private static void setPrintStreamTo(PrintStream printStream) {
        System.setOut(printStream);
    }
}
