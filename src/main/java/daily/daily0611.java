package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/11
 */

public class daily0611 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= 100; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
