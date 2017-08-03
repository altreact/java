import static org.junit.jupiter.api.Assertions.*;

import com.altreact.greedy.input.Converter;
import org.junit.jupiter.api.Test;

class FormatterTest {

    private static double getTwoPointPrecisionOfDouble(double userSimulatedImput) throws Exception {

        return Converter.doubleToTwoPointPrecisionDouble(userSimulatedImput);
    }

    @Test
    void multipleGetTwoPointPrecisionOfDouble() throws Exception {

        double simulatedUserImputedNumbers[] = {1.0, 1.916, 11.916, 123.999, 321.991};
        Double expectedResultingNumbers[] = {1.00, 1.91, 11.91, 123.99, 321.99};

        for (int current = 0; current < simulatedUserImputedNumbers.length; current++) {

            double expected = expectedResultingNumbers[current];
            double actual = getTwoPointPrecisionOfDouble(simulatedUserImputedNumbers[current]);

            assertEquals(expected, actual);
        }
    }
}