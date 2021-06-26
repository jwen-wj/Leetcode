package daily;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class daily0612 {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = cost[i]; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuffer result = new StringBuffer();
        for (int i = 8, j = target; i >= 0; i--) {
            for (int c = cost[i]; j >= c && dp[j] == dp[j - c] + 1; j -= c) {
                result.append(i + 1);
            }
        }
        return result.toString();
    }
}
