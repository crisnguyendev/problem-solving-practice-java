package LeetCode.Blind75.ReverseVowelsString;

public class ReverseVowelsString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
                continue;
            }
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'A':
            case 'u':
            case 'U':
            case 'i':
            case 'I':
            case 'e':
            case 'E':
            case 'o':
            case 'O':
                return true;
            default:
                return false;
        }
    }
}
