package DSA.SlidingWindow.DietPlanPerformance;

public class DietPlanPerformance {
}

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int cal = 0;
        int t = 0;
        for (int i = 0; i < k; i++) {
            cal += calories[i];
        }

        if (cal < lower) {
            t--;
        } else if (cal > upper) {
            t++;
        }

        for (int i = k; i < calories.length; i++) {
            cal = cal + calories[i] - calories[i - k];
            if (cal < lower) {
                t--;
            } else if (cal > upper) {
                t++;
            }
        }
        return t;
    }
}