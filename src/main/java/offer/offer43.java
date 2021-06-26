package offer;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/6
 */

public class offer43 {
    int[] upperBound;
    int[][][] dp;
    public int countDigitOne(int n) {
        String str = String.valueOf(n);
        char[] nums = str.toCharArray();
        // 12345
        int length = nums.length;
        // 5,4,3,2,1
        upperBound = new int[length];
        dp = new int[2][length][length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < length; i++) {
            upperBound[i] = nums[length - 1 - i] - '0';
        }
        return dfs(1, length - 1, 0);
    }

    public int dfs(int limit, int pos, int sum) {
        if (pos == -1) return sum;
        if (dp[limit][pos][sum] != -1) return dp[limit][pos][sum];
        int result = 0 ;
        int maxNum = (limit == 0 ? 9 : upperBound[pos]);
        for (int i = 0; i <= maxNum; i++) {
            result += dfs((i == maxNum && limit == 1 ? 1 : 0), pos - 1, sum + (i == 1 ? 1 : 0));
        }
        dp[limit][pos][sum] = result;
        return result;
    }
}
