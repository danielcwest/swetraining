package dan.swetraining.stocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class StocksTest {
    Stocks s = new Stocks();

    @Test
    public void TestConstructor(){

        assertEquals(true, true);
    }

    @Test
    public void TestMaxProfit(){

        int[] prices = {7,1,5,3,6,4};

        int maxProfit = s.maxProfit(prices);

        assertEquals(maxProfit, 5);

    }

    @Test
    public void TestNoProfit(){

        int[] prices = {7,6,5,3,2,1};

        int maxProfit = s.maxProfit(prices);

        assertEquals(maxProfit, 0);

    }

    @Test
    public void TestStockSymbols(){
        List<StockPrice> stockPrices = new ArrayList<StockPrice>();
        stockPrices.add(new StockPrice("MSFT", new int[]{80, 100, 360, 200, 50}));
        stockPrices.add(new StockPrice("TSLA", new int[]{80, 100, 760, 300, 50}));
        stockPrices.add(new StockPrice("AAPL", new int[]{50, 100, 195, 200, 50}));

        Map<String,String> results = s.maxProfitForSymbols(stockPrices);

        assertEquals(results.get("MSFT"), "280");
        assertEquals(results.get("TSLA"), "680");
        assertEquals(results.get("AAPL"), "150");
    }

    @Test
    public void TestMaxProfitWithFee(){

       // int[] prices = {1,3,2,8,4,9};

        //int maxProfit = s.maxProfitWithFee(prices, 2);

       // assertEquals(8, maxProfit);

    }
    
}
