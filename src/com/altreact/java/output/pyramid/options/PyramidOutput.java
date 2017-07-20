package com.altreact.java.output.pyramid.options;

public class PyramidOutput {

    private static PyramidOutput pyramidOutput;

    public static PyramidOutput getInstance() {

       if (pyramidOutput == null) {
           pyramidOutput = new PyramidOutput();
       }
       return pyramidOutput;
    }

    public static Option toFile() {
        return new File();
    }

    public static Option toScreen() {
        return new Screen();
    }
}
