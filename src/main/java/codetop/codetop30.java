package codetop;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/29
 */

public class codetop30 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = 0;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
