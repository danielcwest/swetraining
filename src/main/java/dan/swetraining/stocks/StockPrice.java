package dan.swetraining.stocks;

public class StockPrice {
    public String symbol;

    public int[] prices;

    public StockPrice(String symbol, int[] prices){
        this.symbol = symbol;
        this.prices = prices;
    }
    
}
