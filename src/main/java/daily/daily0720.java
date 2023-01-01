package daily;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class daily0720 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = n / 2;
        int maxn = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int num = nums[i] + nums[n - i - 1];
            maxn = Math.max(maxn, num);
        }
        return maxn;
    }
}
