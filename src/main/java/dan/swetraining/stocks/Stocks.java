package dan.swetraining.stocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stocks {
    
    Map<String,String> profits = new HashMap<String,String>();

    public Stocks(){}

    public Map<String, String> maxProfitForSymbols(List<StockPrice> stockPrices){

        stockPrices.forEach(s -> profits.put(s.symbol, maxProfit(s.prices)+""));

        return this.profits;
    }
    
    public int maxProfit(int[] prices){
        int maxProfit = 0;

        int priceInFocus = 0;
        int[] forwardPrices = Arrays.copyOfRange(prices, 1, prices.length);
        //Look at each value and calculate the max profit of future prices
        for(int i = 0; i < prices.length - 1; i++){
            priceInFocus = prices[i];
            for(int j = 0; j < forwardPrices.length; j++){
                int profit = forwardPrices[j] - priceInFocus;

                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
            forwardPrices = Arrays.copyOfRange(prices, i+2, prices.length);
        }

        return maxProfit;
    }

    public int maxProfitWithFee(int[] prices, int fee){
        int maxProfit = 0;

        int priceInFocus = 0;
        int[] forwardPrices = Arrays.copyOfRange(prices, 1, prices.length);
        //Look at each value and calculate the max profit of future prices
        for(int i = 0; i < prices.length - 1; i++){
            priceInFocus = prices[i];
            int profit = 0;
            for(int j = 0; j < forwardPrices.length; j++){

                int localProfit = (forwardPrices[j] - fee) - priceInFocus;

                if(localProfit > 0){
                    profit += localProfit;
                }

            }

            if(profit > maxProfit){
                maxProfit = profit;
            }

            forwardPrices = Arrays.copyOfRange(prices, i+2, prices.length);
        }

        return maxProfit;
    }
}
