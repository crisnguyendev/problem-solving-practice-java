package DSA.TwoPointers.ReverseWordInString;

public class ReverseWordInString {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(new Solution().reverseWords(s));
    }
}

class Solution {
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();

        char[] charArray = sentence.toCharArray();
        int lastIndex = charArray.length - 1;

        reverse(charArray, 0, lastIndex);
        int start = 0;
        for (int end = 0; end <= lastIndex; ++end) {
            if (end == lastIndex || charArray[end] == ' ') {
                int endIndex = (end == lastIndex ) ? end : end - 1;
                reverse(charArray, start, endIndex);
                start = end + 1;
            }
        }

        return new String(charArray);
    }

}
