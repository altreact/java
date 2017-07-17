package com.altreact.java.input;

import com.altreact.java.output.UserInputPrompts;
import com.altreact.java.output.pyramid.Constraints;

public class User {

    private static UserInputPrompts userInputPrompts = new UserInputPrompts();
    private static Constraints constraints = new Constraints();
    private static Keyboard selection = new Keyboard();

    protected static int getUserSelectedNumberOfRows() {

        Keyboard numberOfRows = getUserNumberOfRowsSelection();
        return userSelection(numberOfRows);
    }

    protected static int getUserSelectedOutputOption() {

        Keyboard pyramidOutputOption = getUserPyramidOutputOptionSelection();
        return userSelection(pyramidOutputOption);
    }

    private static int userSelection(Keyboard selection) {
        return selection.getValueWithinConstraints();
    }

    private static Keyboard getUserNumberOfRowsSelection() {

        return getSelection(
                userInputPrompts.numberOfRows,
                constraints.numberOfRowsHighestAcceptableValue,
                constraints.numberOfRowsLowestAcceptableValue
        );
    }

    private static Keyboard getUserPyramidOutputOptionSelection() {
        return getSelection(

                userInputPrompts.pyramidOutputOptions,
                constraints.outputOptionsHighestAcceptableValue,
                constraints.outputOptionsLowestAcceptableValue
        );
    }

    private static Keyboard getSelection(String userPromptMessage, int highestAcceptableValue,
            int lowestAcceptableValue) {

        selection.setUserPromptMessage(userPromptMessage);
        selection.setHighestAcceptableValue(highestAcceptableValue);
        selection.setLowestAcceptableValue(lowestAcceptableValue);

        return selection;
    }
}
