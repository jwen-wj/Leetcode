package leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int closest = target + 10_001;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int l = j;
                int r = len - 1;
                while (l < r) {
                    int temp = nums[i] + nums[l] + nums[r];
                    closest = Math.abs(closest - target) < Math.abs(temp - target) ? closest : temp;
                    if (temp > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return closest;
    }
}
