package com.altreact.greedy;

import com.altreact.greedy.input.Keyboard;
import com.altreact.greedy.output.ScreenOutput;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.altreact.greedy.output.SimplerOutput.*;

public class Greedy {

    private static char currency = '$';
    private static String userInputPrompt = "Enter the amount of money you need change for: " + currency;
    private static double amountToMakeChangeFor = 0;
    private CoinCalculator coinCalculator;
    private static CoinCalculator.Results coinCalculationResult;

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");

        Greedy greedy = (Greedy) context.getBean("greedy");

        greedy.start();
    }

    public Greedy(CoinCalculator coinCalculator) {
        this.coinCalculator = coinCalculator;
    }

    private void start() {

        ScreenOutput.displayProgramNameAndDescription();
        amountToMakeChangeFor = Keyboard.getAmountToMakeChangeFor(userInputPrompt);
        coinCalculationResult = coinCalculator.getCoinCalculationResults(amountToMakeChangeFor);
        outputCoinCalculationSummary();
    }

    private static void outputCoinCalculationSummary() {

        outputLine(coinCalculationResult.getSummary());
        System.out.printf(" in " + currency + "%.2f.", amountToMakeChangeFor);
        outputEmptyLine();
    }
}
