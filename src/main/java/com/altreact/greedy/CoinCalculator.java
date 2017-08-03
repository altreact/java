package com.altreact.greedy;

public class CoinCalculator {

    private static int[] coinValue = {100, 50, 25, 10, 5, 1};
    private static int[] coinCount = {0, 0, 0, 0, 0, 0};
    private static int amountLeftToMakeChangeFor = 0;
    private static int lastCoinInListOfCoins = coinValue.length;

    public int[] calculateNumberOfCoinsForEachCoinValue(double amountToMakeChangeFor) {

        amountLeftToMakeChangeFor = doubleToPennies(amountToMakeChangeFor);

        for (int thisCoin = 0; thisCoin != lastCoinInListOfCoins; thisCoin++) {
            coinCount[thisCoin] = getMaxCoinCountOfCoinForChange(coinValue[thisCoin]);
        }

        return coinCount;
    }

    public static int doubleToPennies(double decimal) {
        return (int) (decimal * 100);
    }

    private static int getMaxCoinCountOfCoinForChange(int valueOfThisCoin) {

        int numberOfThisCoinInTotalChange = 0;

        if (amountLeftToMakeChangeFor - valueOfThisCoin >= 0) {

            numberOfThisCoinInTotalChange = amountLeftToMakeChangeFor / valueOfThisCoin;
            amountLeftToMakeChangeFor %= valueOfThisCoin;
            updateAmountLeftToMakeChangeFor(valueOfThisCoin);
        }

        return numberOfThisCoinInTotalChange;
    }

    private static void updateAmountLeftToMakeChangeFor(int divisorToGetRemainderFrom) {

        amountLeftToMakeChangeFor %= divisorToGetRemainderFrom;
    }
}
