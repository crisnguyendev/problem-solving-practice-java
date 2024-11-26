package DSA.FastAndSlowPointers.CircularArrayLoop;

public class CircularArrayLoop {
}

class Solution {
    public static boolean circularArrayLoop(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextStep(slow, nums[slow], size);

                if (!isInValidCycle(nums, forward, slow))
                    break;

                fast = nextStep(fast, nums[fast], size);

                if (!isInValidCycle(nums, forward, fast))
                    break;

                fast = nextStep(fast, nums[fast], size);

                if (!isInValidCycle(nums, forward, fast))
                    break;

                if (slow == fast)
                    return true;
            }
        }

        return false;
    }

    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0)
            result += size;
        return result;
    }

    public static boolean isInValidCycle(int[] nums, boolean prevDirection, int pointer) {
        boolean currDirection = nums[pointer] >= 0;
        return prevDirection == currDirection && Math.abs(nums[pointer] % nums.length) != 0;
    }
}