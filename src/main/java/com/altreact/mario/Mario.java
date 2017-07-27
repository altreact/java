package com.altreact.mario;

import static com.altreact.mario.input.User.getUserSelectedNumberOfRows;
import static com.altreact.mario.input.User.getUserSelectedOutputOption;
import com.altreact.mario.output.SimplerPrint;

import com.altreact.mario.output.pyramid.options.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mario extends SimplerPrint {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Mario marioObject = (Mario) context.getBean("mario");
        marioObject.start();
    }

    private static Option userSelectedOutputOption;
    private static Pyramid pyramid = new Pyramid();
    private static int userSelectedPyramidOutputOption;

    private void start() {

        displayStartMessage();
        outputMarioPyramid();
    }

    private void displayStartMessage() {

        outputEmptyLine();
        outputLine("Mario");
        outputEmptyLine();
        outputLine("   ##");
        outputLine("  ###");
        outputLine(" ####");
        outputEmptyLine();
        output("Outputs Mario Pyramid, based on user inputted pyramid height.");
        outputEmptyLine();
        outputEmptyLine();
        outputLine("**************************************************************");
        outputEmptyLine();
    }

    private static void outputMarioPyramid() {
        letUserSelectNumberOfRowsInPyramid();
        letUserSelectPyramidOutputOption();
        setPyramidOutputOption();
        outputPyramid();
    }

    private static void letUserSelectNumberOfRowsInPyramid() {
        pyramid.setNumberOfRows(userSelectedNumberOfRows());
    }

    private static int userSelectedNumberOfRows() {
        return getUserSelectedNumberOfRows();
    }

    private static void letUserSelectPyramidOutputOption() {
        userSelectedPyramidOutputOption = getUserSelectedOutputOption();
    }

    private static void setPyramidOutputOption() {
        if (pyramidOutputToFileWasChosenByUser()) {
            userSelectedOutputOption = PyramidOutput.toFile();
        } else {
            userSelectedOutputOption = PyramidOutput.toScreen();
        }
    }

    private static boolean pyramidOutputToFileWasChosenByUser() {
        return userSelectedPyramidOutputOption == 2;
    }

    private static void outputPyramid() {
        userSelectedOutputOption.pyramidOutputStrategy(pyramid);
    }
}
