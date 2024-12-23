package DSA.PrefixSum.RangeSumQueryImmutable;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.print(na.sumRange(2, 5));
    }
}

class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = nums;
        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */