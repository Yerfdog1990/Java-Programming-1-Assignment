package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {

        ArrayList<Float> stockPricesList = new ArrayList<>();

        try(Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter stock prices separated by commas: ");
            String stockPricesString = userInput.nextLine();
            String[] stockPricesArray = stockPricesString.split(",");
            float[] stockPrices = new float[stockPricesArray.length];
            System.out.print("Enter the target price: ");
            int targetPrice = userInput.nextInt();
            logger.info("Target price: {}", targetPrice);
            System.out.println("Stock prices list: "+stockPricesString);
            logger.info("Stock prices list: {}", stockPricesString);
            for (int i = 0; i < stockPricesArray.length; i++) {
                stockPrices[i] = Float.parseFloat(stockPricesArray[i]);
                stockPricesList.add(stockPrices[i]);
            }
            StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, stockPricesList);
            if (stockAnalysis.countOccurrences(stockPrices, targetPrice) < 0) {
                throw new IllegalArgumentException("Target price not found");
            }else{
                System.out.println("Average Price: " + stockAnalysis.calculateAveragePrice(stockPrices));
                logger.info("Average Price: {}", stockAnalysis.calculateAveragePrice(stockPrices));
                System.out.println("Maximum Price: " + stockAnalysis.findMaximumPrice(stockPrices));
                logger.info("Maximum Price: {}", stockAnalysis.findMaximumPrice(stockPrices));
                System.out.println("Minimum Price: " + stockAnalysis.findMinimumPrice(stockPrices));
                logger.info("Minimum Price: {}", stockAnalysis.findMinimumPrice(stockPrices));
                System.out.println("Median Price: " + stockAnalysis.findMedianPrice(stockPrices));
                logger.info("Median Price: {}", stockAnalysis.findMedianPrice(stockPrices));
                System.out.println("Mode Price: " + stockAnalysis.findModePrice(stockPrices));
                logger.info("Mode Price: {}", stockAnalysis.findModePrice(stockPrices));
                System.out.println("Range Price: " + stockAnalysis.findRangePrice(stockPrices));
                logger.info("Range Price: {}", stockAnalysis.findRangePrice(stockPrices));
                System.out.println("Number of occurrences of " +targetPrice+ " : " + stockAnalysis.countOccurrences(stockPrices, 30));
                logger.info("Number of occurrences of {} : {}", targetPrice, stockAnalysis.countOccurrences(stockPrices, 30));
                System.out.println("Cumulative Sum: " + stockAnalysis.computeCumulativeSum(stockPricesList));
                logger.info("Cumulative Sum: {}", stockAnalysis.computeCumulativeSum(stockPricesList));
            }
        }
    }
}