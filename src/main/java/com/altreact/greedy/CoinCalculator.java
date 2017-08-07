package com.altreact.greedy;

import com.altreact.greedy.input.Converter;

public class CoinCalculator {

    private static String[] coinName = {"dollar", "half dollar", "quarter", "dime", "nickel", "penny"};
    private static int[] coinValue = {100, 50, 25, 10, 5, 1};
    private static int[] coinCount = {0, 0, 0, 0, 0, 0};
    private static int totalCoinCount = 0;
    private static int amountLeftToMakeChangeFor = 0;
    private static int lastCoinInListOfCoins = coinValue.length;

    public class Results {

        private int[] coinCount;
        private String resultSummary;

        Results(int[] coinCount, String resultSummary) {

            this.coinCount = coinCount;
            this.resultSummary = resultSummary;
        }

        public int[] getCoinCountsForEachCoinValue() {
            return coinCount;
        }

        String getSummary() {
            return resultSummary;
        }
    }

    public Results getCoinCalculationResults(double amountToMakeChangeFor) {

        calculateCoins(amountToMakeChangeFor);
        return new Results(coinCount, getCoinCalculationResultsSummary());
    }

     private void calculateCoins(double amountToMakeChangeFor) {

         amountLeftToMakeChangeFor = Converter.doubleToPennies(amountToMakeChangeFor);

         for (int thisCoin = 0; thisCoin != lastCoinInListOfCoins; thisCoin++) {
             coinCount[thisCoin] = getMaxCoinCountOfCoinForChange(coinValue[thisCoin]);
             totalCoinCount += coinCount[thisCoin];
         }
     }

    private int getMaxCoinCountOfCoinForChange(int valueOfThisCoin) {

        int numberOfThisCoinInTotalChange = 0;

        if (amountLeftToMakeChangeFor - valueOfThisCoin >= 0) {

            numberOfThisCoinInTotalChange = amountLeftToMakeChangeFor / valueOfThisCoin;
            amountLeftToMakeChangeFor %= valueOfThisCoin;
            updateAmountLeftToMakeChangeFor(valueOfThisCoin);
        }

        return numberOfThisCoinInTotalChange;
    }

    private void updateAmountLeftToMakeChangeFor(int divisorToGetRemainderFrom) {

        amountLeftToMakeChangeFor %= divisorToGetRemainderFrom;
    }

     private static String getCoinCalculationResultsSummary() {

         StringBuilder coinCalculationResultsSummary = new StringBuilder();
         int lastCoinInList = coinCount.length;

         coinCalculationResultsSummary.append("There are:\n\n");

         for (int thisCoin = 0; thisCoin < lastCoinInList; thisCoin++) {

             int thisCoinCount= coinCount[thisCoin];
             String thisCoinName = coinName[thisCoin];

             if (thisCoinCount != 0) {

                 coinCalculationResultsSummary.append(getSummaryStringForCoin(thisCoinCount, thisCoinName));
             }
         }

         coinCalculationResultsSummary.append("\n");
         coinCalculationResultsSummary.append(" For a total of ").append(totalCoinCount).append(" coins,");
         coinCalculationResultsSummary.append("\n");

         return coinCalculationResultsSummary.toString();
     }

     public static String getSummaryStringForCoin(int thisCoinCount, String coinName) {

         if (thisCoinCount != 1) {

             int lengthOfCoinName = coinName.length();
             char lastLetterOfCoinName = coinName.charAt(lengthOfCoinName - 1);

             if (lastLetterOfCoinName != 'y') {
                 coinName += "s";
             } else {
                 String coinNameMinusTheTrailingLetterY = coinName.substring(0,  lengthOfCoinName- 1);
                 coinName = coinNameMinusTheTrailingLetterY + "ies";
             }
         }

         return "    " + thisCoinCount + " " + coinName + ",\n";
     }
}
