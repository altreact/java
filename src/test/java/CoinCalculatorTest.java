import com.altreact.greedy.CoinCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinCalculatorTest {

    private static CoinCalculator coinCalculator;
    private static CoinCalculator.Results coinCalculationResult;

    private static void getNewCoinCalculationResult(double amountToMakeChangeFor) {

        coinCalculator = new CoinCalculator();
        coinCalculationResult = coinCalculator.getCoinCalculationResults(amountToMakeChangeFor);
    }

    private void calculateNumberOfCoinsForEachCoinValue(int[] expectedCoinCounts, double number) {

        getNewCoinCalculationResult(number);
        assertArrayEquals(expectedCoinCounts, coinCalculationResult.getCoinCountsForEachCoinValue());
    }

    @Test
    void multipleCalculateNumberOfCoinsForEachCoinValue() {


        int coinCountsForOneDotNineOne[] = {1,1,1,1,1,1};
        calculateNumberOfCoinsForEachCoinValue(coinCountsForOneDotNineOne, 1.91);

        int coinCountsForZero[] = {0,0,0,0,0,0};
        calculateNumberOfCoinsForEachCoinValue(coinCountsForZero, 0);
    }

    private String getSummaryStringForCoin(int thisCoinCount, String coinName) {

        return CoinCalculator.getSummaryStringForCoin(thisCoinCount, coinName);
    }

    private String getFormattedString(int number, String name) {

        return "    " + number + " " + name + ",\n";
    }

    @Test
    void multipleGetSummaryForCoin() {

        assertEquals(getFormattedString(1, "penny"), getSummaryStringForCoin(1, "penny"));
        assertEquals(getFormattedString(2, "pennies"), getSummaryStringForCoin(2, "penny"));
        assertEquals(getFormattedString(3, "quarters"), getSummaryStringForCoin(3, "quarter"));
        assertEquals(getFormattedString(1, "quarter"), getSummaryStringForCoin(1, "quarter"));
    }
}