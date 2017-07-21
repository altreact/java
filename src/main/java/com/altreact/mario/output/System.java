package com.altreact.mario.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

public class System extends SimplerPrint {

    private static PrintStream consolePrintStream;

    public static void setFileOutputPrintStream() {
        PrintStream filePrintStream = getFilePrintStream();
        setPrintStreamTo(filePrintStream);
    }

    private static PrintStream getFilePrintStream() {

        PrintStream printStream;
        consolePrintStream = java.lang.System.out;

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

    public static void setConsolePrintStream() {
        setPrintStreamTo(consolePrintStream);
    }

    private static void setPrintStreamTo(PrintStream printStream) {
        java.lang.System.setOut(printStream);
    }
}
