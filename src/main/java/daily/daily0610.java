package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class daily0610 {
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}
