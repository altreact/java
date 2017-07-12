package com.altreact.java.output;

public class SimplerOutput {

    protected static void outputEmptyLine() {
        System.out.println();
    }

    protected static void output(String string) {
        System.out.print(string);
    }

    static void output(int integer) {
        System.out.print(integer);
    }

    static void outputLine(String string) {
        System.out.println(string);
    }

    static void outputLine(int integer) {
        System.out.println(integer);
    }
}
