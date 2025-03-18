package LeetCode.Blind75.StringCompression;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.print(new StringCompression().compress(chars));
    }

    public int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; ) {
            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                count = count + 1;
                i++;
            }

            chars[index] = current;
            index++;

            if (count > 1) {
                char[] countChars = Integer.toString(count).toCharArray();
                for (char countChar : countChars) {
                    chars[index] = countChar;
                    index++;
                }
            }
        }
        return index;
    }
}
