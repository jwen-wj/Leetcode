package pinduoduo;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class second {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 8, 9};
        int k = 5;
        Arrays.sort(nums);
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int L = 1;
        int R = 1;
        int maxLen = 0;
        while (R < dp.length) {
            while (!valid(dp, nums, k, L, R)) {
                L++;
            }
            int len = R - L + 1;
            maxLen = Math.max(maxLen, len);
            R++;
        }
        System.out.println(maxLen);
    }

    public static boolean valid(int[] dp, int[] nums, int k, int L, int R) {
        int sum = dp[R] - dp[L - 1];
        int max = nums[R - 1];
        int len = R - L + 1;
        int old_sum = len * max;
        return old_sum <= k + sum;
    }
}
