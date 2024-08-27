package easy.MajorityElement;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 1, 2, 2};
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0, candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (num == candidate)
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }

}