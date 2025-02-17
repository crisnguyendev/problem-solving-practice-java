package LeetCode.TopInterview150.BestTimeToBuyAndSellStockII;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int buyPrice = prices[0];
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                totalProfit += (prices[i] - buyPrice);
                buyPrice = prices[i];
            }
        }
        return totalProfit;
    }
}
