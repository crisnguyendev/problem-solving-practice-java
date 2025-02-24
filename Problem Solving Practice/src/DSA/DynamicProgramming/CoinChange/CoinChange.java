package DSA.DynamicProgramming.CoinChange;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int amount = 5;
        System.out.print(new Solution().coinChange(coins, amount));
    }
}

// Top-down approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] counters = new int[amount];
        Arrays.fill(counters, Integer.MAX_VALUE);
        return calculateMinCoins(coins, counters, amount);
    }

    private int calculateMinCoins(int[] coins, int[] counters, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (counters[amount - 1] != Integer.MAX_VALUE)
            return counters[amount - 1];
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            result = calculateMinCoins(coins, counters, amount - coins[i]);
            if (result >= 0 && result < min)
                min = result + 1;
        }
        if (min != Integer.MAX_VALUE) {
            counters[amount - 1] = min;
        } else {
            counters[amount - 1] = -1;
        }
        return counters[amount - 1];
    }
}

class OptimalSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
