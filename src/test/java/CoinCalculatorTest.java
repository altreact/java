import com.altreact.greedy.CoinCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinCalculatorTest {

    private static int doubleToPennies(double amount) {

        return CoinCalculator.doubleToPennies(amount);
    }

        @Test
        void multipleDoubleToPennies() {


            double doubles[] = {0.10, 1.91, 22.87, 44.88, 0, 5};
            double expectedDoubles[] = {10, 191, 2287, 4488, 0, 500};

            for (int current = 0; current < doubles.length; current++) {

                double expected = expectedDoubles[current];
                double actual = doubleToPennies(doubles[current]);

                assertEquals(expected, actual);
            }
        }

    private void calculateNumberOfCoinsForEachCoinValue(int[] expectedCoinCounts, double number) {

        CoinCalculator coinCalculator = new CoinCalculator();
        assertArrayEquals(expectedCoinCounts, coinCalculator.calculateNumberOfCoinsForEachCoinValue(number));
    }

    @Test
    void multipleCalculateNumberOfCoinsForEachCoinValue() {


        int coinCountsForOneDotNineOne[] = {1,1,1,1,1,1};
        calculateNumberOfCoinsForEachCoinValue(coinCountsForOneDotNineOne, 1.91);

        int coinCountsForZero[] = {0,0,0,0,0,0};
        calculateNumberOfCoinsForEachCoinValue(coinCountsForZero, 0);
    }

}