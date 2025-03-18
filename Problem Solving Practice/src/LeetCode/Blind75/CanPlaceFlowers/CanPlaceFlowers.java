package LeetCode.Blind75.CanPlaceFlowers;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int planted = 0;
        int i = 0;
        while (planted < n && i < length) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            boolean emptyLeft = i == 0 || flowerbed[i - 1] == 0;
            boolean emptyRight = i == length - 1 || flowerbed[i + 1] == 0;
            if(emptyLeft && emptyRight) {
                flowerbed[i] = 1;
                planted++;
                i += 2;
            } else {
                i++;
            }
        }
        return planted == n;
    }
}
