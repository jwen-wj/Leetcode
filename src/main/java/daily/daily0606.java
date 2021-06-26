package daily;

import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/6
 */

public class daily0606 {
    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[] one = new int[strs.length];
        int[] zero = new int[strs.length];
        int len = 0;
        for (String str : strs) {
            int oneCount = 0, zeroCount = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '1') oneCount++;
                else zeroCount++;
            }
            one[len] = oneCount;
            zero[len++] = zeroCount;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= zero[i] ; j--) {
                for (int k = n; k >= one[i]; k--) {
                    dp[j][k] = Math.max(dp[j - zero[i]][k - one[i]] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
