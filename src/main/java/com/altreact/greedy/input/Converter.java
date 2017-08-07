package com.altreact.greedy.input;

public class Converter {

    static double stringToDouble(String value) {

        double number;

        try {
            number = Double.valueOf(value);
        } catch (NumberFormatException e) {
            number = -1.00;
        }
        return number;
    }

    public static double doubleToTwoPointPrecisionDouble(double number ) {

        String decimalString = Double.toString(number);
        int decimalStringLength = decimalString.length();
        int indexOfDecimalPoint = decimalString.indexOf('.');
        int beginningOfNumber = 0;
        int twoPlacesPastDecimalPoint = 3;

        String doubleWithTwoDigitPrecision;
        int preciseNumberLength;

        if (indexOfDecimalPoint + twoPlacesPastDecimalPoint <=   decimalStringLength) {

            preciseNumberLength = indexOfDecimalPoint + twoPlacesPastDecimalPoint;
            doubleWithTwoDigitPrecision = decimalString.substring(beginningOfNumber, preciseNumberLength);
        } else {
            doubleWithTwoDigitPrecision = decimalString + "0";
        }

        return Double.parseDouble(doubleWithTwoDigitPrecision);
    }

    public static int doubleToPennies(double decimal) {
        return (int) (decimal * 100);
    }
}
