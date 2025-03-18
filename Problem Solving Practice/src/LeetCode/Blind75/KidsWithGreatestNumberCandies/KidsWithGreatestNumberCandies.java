package LeetCode.Blind75.KidsWithGreatestNumberCandies;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for (int candy : candies) {
            if (greatest < candy) {
                greatest = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= greatest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
