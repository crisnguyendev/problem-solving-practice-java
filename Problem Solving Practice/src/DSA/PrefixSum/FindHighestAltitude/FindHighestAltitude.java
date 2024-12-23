package DSA.PrefixSum.FindHighestAltitude;

public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.print(new Solution().largestAltitude(gain));
    }

}

class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] sum = new int[n];
        sum[0] = gain[0];
        int max = sum[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + gain[i];
            max = Math.max(sum[i], max);
        }
        return Math.max(max, 0);
    }
}