package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/9
 */

public class daily0609 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        int len = group.length;

        for (int i = 1; i <= len; i++) {
            int members = group[i - 1];
            int earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % mod;
                }
            }
        }
        return dp[n][minProfit];
    }
}
