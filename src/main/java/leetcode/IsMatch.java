package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/30
 */

public class IsMatch {
    public boolean matches(String s, String p, int i ,int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[31][31];
        dp[0][0] = true;
        int m = s.length();
        int n = p.length();
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
