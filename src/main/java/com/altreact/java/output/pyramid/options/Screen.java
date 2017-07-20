package com.altreact.java.output.pyramid.options;

import com.altreact.java.Pyramid;
import com.altreact.java.input.User;

public class Screen extends User implements Option {

    @Override
    public void pyramidOutputStrategy(Pyramid pyramid) {
        pyramid.outputPyramid();
    }
}
