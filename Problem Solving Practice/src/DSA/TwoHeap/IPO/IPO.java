package DSA.TwoHeap.IPO;

import java.util.PriorityQueue;

public class IPO {
}


class Invest {
    int capital;
    int profit;

    public Invest(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Invest> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        PriorityQueue<Invest> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            if (w >= capital[i])
                maxProfitHeap.add(new Invest(capital[i], profits[i]));
            else
                minCapitalHeap.add(new Invest(capital[i], profits[i]));
        }
        int totalCapital = w;
        while (!maxProfitHeap.isEmpty() && k > 0) {
            Invest invest = maxProfitHeap.poll();
            if (invest.capital <= totalCapital) {
                totalCapital += invest.profit;
                k--;
            } else {
                minCapitalHeap.add(invest);
            }
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= totalCapital) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
        }
        return totalCapital;
    }
}