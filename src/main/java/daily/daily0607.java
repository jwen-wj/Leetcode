package daily;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/7
 */

public class daily0607 {
    int[] nums;
    int target;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dp = new int[nums.length][2002];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0);
    }

    public int dfs(int pos, int sum) {
        if (pos == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (dp[pos][sum + 1000] != -1) return dp[pos][sum + 1000];
        int result = 0;
        result += dfs(pos + 1, sum + nums[pos]) + dfs(pos + 1, sum - nums[pos]);
        dp[pos][sum + 1000] = result;
        return result;
    }
}
