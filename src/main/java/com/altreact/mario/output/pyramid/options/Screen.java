package com.altreact.mario.output.pyramid.options;

import com.altreact.mario.Pyramid;
import com.altreact.mario.input.User;

public class Screen extends User implements Option {

    @Override
    public void pyramidOutputStrategy(Pyramid pyramid) {
        pyramid.outputPyramid();
    }
}
