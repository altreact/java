package com.altreact.java;

public class Pyramid extends SimplerOutput {

    private int numberOfRows;
    private int numberOfHashes;
    private int numberOfSpaces;
    private int currentRowNumber;

    void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    void outputPyramid() {
        outputPyramidRows();
    }

    private void outputPyramidRows() {
        for (currentRowNumber = 1; currentRowNumber < numberOfRows + 1; currentRowNumber++) {
            outputPyramidRow();
        }
    }

    private void outputPyramidRow() {
        generatePyramidRowValues();
        output(getRepeatedSpacesString() + getRepeatedHashesString() + "\n");
        resetPyramidRowValues();
    }

    private void generatePyramidRowValues(){
        generateHashSubstring();
        generateSpaceSubstring();
    }

    private void generateHashSubstring() {
        numberOfHashes = 1 + currentRowNumber;
    }

    private void generateSpaceSubstring() {
        numberOfSpaces = numberOfRows + 1 - numberOfHashes;
    }

    private void resetPyramidRowValues() {
        numberOfHashes = 0;
        numberOfSpaces = 0;
    }

    private String getRepeatedSpacesString() {
        return getRepeatedCharacterString(numberOfSpaces, ' ');
    }

    private String getRepeatedHashesString() {
        return getRepeatedCharacterString(numberOfHashes, '#');
    }

    private String getRepeatedCharacterString(int numberOfTimesToRepeatCharacter, char characterToRepeat) {
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
