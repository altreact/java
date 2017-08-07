import static org.junit.jupiter.api.Assertions.*;
import com.altreact.greedy.input.Converter;
import org.junit.jupiter.api.Test;

class ConverterTest {

    private static double getTwoPointPrecisionOfDouble(double userSimulatedImput) {

        return Converter.doubleToTwoPointPrecisionDouble(userSimulatedImput);
    }

    @Test
    void multipleGetTwoPointPrecisionOfDouble() {

        double simulatedUserImputedNumbers[] = {1.0, 1.916, 11.916, 123.999, 321.991};
        Double expectedResultingNumbers[] = {1.00, 1.91, 11.91, 123.99, 321.99};

        for (int current = 0; current < simulatedUserImputedNumbers.length; current++) {

            double expected = expectedResultingNumbers[current];
            double actual = getTwoPointPrecisionOfDouble(simulatedUserImputedNumbers[current]);

            assertEquals(expected, actual);
        }
    }

    private static int doubleToPennies(double amount) {

        return Converter.doubleToPennies(amount);
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
}