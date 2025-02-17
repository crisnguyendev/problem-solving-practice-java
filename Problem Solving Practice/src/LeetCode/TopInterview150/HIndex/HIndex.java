package LeetCode.TopInterview150.HIndex;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new Solution().hIndex(citations));
    }
}

class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] count = new int[length + 1];

        for (int citation : citations)
            if (citation > length)
                count[length]++;
            else
                count[citation]++;

        int total = 0;
        for (int i = length; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }

        return 0;
    }
}