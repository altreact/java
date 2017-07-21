package com.altreact.java;

import com.altreact.java.output.SimplerPrint;

public class Pyramid extends SimplerPrint {

    private static int numberOfRows;
    private static int numberOfHashes;
    private static int numberOfSpaces;
    private static int currentRowNumber;

    void setNumberOfRows(int userEnteredNumberOfRows) {
        numberOfRows = userEnteredNumberOfRows;
    }

    public void outputPyramid() {
        outputPyramidRows();
    }

    private static void outputPyramidRows() {
        for (currentRowNumber = 1; currentRowNumber < numberOfRows + 1; currentRowNumber++) {
            outputPyramidRow();
        }
    }

    private static void outputPyramidRow() {
        generatePyramidRowValues();
        output(getRepeatedSpacesString() + getRepeatedHashesString() + "\n");
        resetPyramidRowValues();
    }

    private static void generatePyramidRowValues(){
        generateHashSubstring();
        generateSpaceSubstring();
    }

    private static void generateHashSubstring() {
        numberOfHashes = 1 + currentRowNumber;
    }

    private static void generateSpaceSubstring() {
        numberOfSpaces = numberOfRows + 1 - numberOfHashes;
    }

    private static void resetPyramidRowValues() {
        numberOfHashes = 0;
        numberOfSpaces = 0;
    }

    private static String getRepeatedSpacesString() {
        return getRepeatedCharacterString(numberOfSpaces, ' ');
    }

    private static String getRepeatedHashesString() {
        return getRepeatedCharacterString(numberOfHashes, '#');
    }

    private static String getRepeatedCharacterString(int numberOfTimesToRepeatCharacter, char characterToRepeat) {
        StringBuilder repeatedCharacterStringBuilder = new StringBuilder();
        for (int x = 0; x < numberOfTimesToRepeatCharacter; x++) {
            repeatedCharacterStringBuilder.append(characterToRepeat);
        }
        return repeatedCharacterStringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Pyramid{}";
    }
}
