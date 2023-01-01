package daily;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
 */

public class daily0719 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 8, 13};
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return 1;
        Arrays.sort(nums);
        int total = 0;
        int l = 0;
        int maxn = Integer.MIN_VALUE;
        for (int r = 1; r < len; r++) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                l++;
            }
            maxn = Math.max(maxn, r - l + 1);
        }
        return maxn;
    }
}
