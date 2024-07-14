package fkswitch.sliding_window;

public class StockBuySell {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int b = 0, e = b + 1;
        while (e < prices.length) {
            if (prices[e] > prices[b]) {
                maxProfit = Math.max(maxProfit, prices[e] - prices[b]);
            } else {
                b = e;
            }
            e++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {

        StockBuySell stockBuySell = new StockBuySell();
        int[] prices = { 1,2,4,2,5,7,2,4,9,0,9 };
        System.out.println(stockBuySell.maxProfit(prices));
    }
}
