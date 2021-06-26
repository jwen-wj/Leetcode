package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/26
 */

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int Length = s.length();
        int maxLen = 1;
        int begin = 0;
        Boolean[][] dp = new Boolean[1001][1001];
        for (int i = 0; i < Length; i++) {
            dp[i][i] = true;
        }
        if (Length == 1) {
            return s;
        }
        for (int len = 2; len <= Length; len++) {
            for (int i = 0; i < Length; i++) {
                int j = i + len - 1;
                if (j >= Length) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
