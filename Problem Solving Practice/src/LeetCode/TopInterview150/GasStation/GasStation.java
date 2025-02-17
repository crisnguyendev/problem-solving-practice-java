package LeetCode.TopInterview150.GasStation;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int subSum = n + 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < subSum) {
                subSum = total;
                start = i + 1;
            }
        }

        return total >= 0 ? (start % n) : -1;
    }
}