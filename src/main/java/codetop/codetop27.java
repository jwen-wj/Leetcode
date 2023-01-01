package codetop;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/27
 */

public class codetop27 {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right++;
        }
        return right - left - 1;
    }
}
