import org.example.StockAnalysis;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

public class StockAnalysisTest {
    @Test
    @DisplayName("Average price test")
    void calculateAveragePriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.calculateAveragePrice(stockPrices) == 3.3f;
    }
    @Test
    @DisplayName("Mode price test")
    void findModePriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 1.1f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.findModePrice(stockPrices) == 1.1f;
    }
    @Test
    @DisplayName("Maximum price test")
    void findMaximumPriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.findMaximumPrice(stockPrices) == 5.5f;
    }
    @Test
    @DisplayName("Minimum price test")
    void findMinimumPriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.findMinimumPrice(stockPrices) == 1.1f;
    }
    @Test
    @DisplayName("Median price test")
    void findMedianPriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.findMedianPrice(stockPrices) == 3.3f;
    }
    @Test
    @DisplayName("Range price test")
    void findRangePriceTest() {
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.findRangePrice(stockPrices) == 4.4f;
    }
    @ParameterizedTest
    @DisplayName("Count occurrences test")
    @CsvSource({"1, 1", "2, 1", "3, 1", "4, 1", "5, 1", "6, 0"})
    void countOccurrencesTest(int targetPrice, int expectedCount) {
        float[] stockPrices = {1, 2, 3, 4, 5};
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, null);
        assert stockAnalysis.countOccurrences(stockPrices, targetPrice) == expectedCount;
    }
    @Test
    @DisplayName("Cumulative sum test")
    void computeCumulativeSumTest() {
        float sum = 0;
        float[] stockPrices = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        ArrayList<Float> stockPricesList = new ArrayList<>();
        for (float price : stockPrices) {
            stockPricesList.add(price);
            sum += price;
        }
        StockAnalysis stockAnalysis = new StockAnalysis(stockPrices, stockPricesList);
        assert stockAnalysis.computeCumulativeSum(stockPricesList).get(stockPricesList.size() - 1) == sum;
    }
}
