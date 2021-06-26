package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/26
 */

public class FourNumbers {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int t = 0; t < len; t++) {
            if (t > 0 && nums[t] == nums[t - 1]) {
                continue;
            }
            for (int i = t + 1; i < len; i++) {
                if (i > t + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < len ; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = len - 1;
                    while (j < k && nums[i] + nums[j] + nums[k] + nums[t]> target) {
                        k--;
                    }
                    if (nums[i] + nums[j] + nums[k] + nums[t] == target && j != k) {
                        result.add(Arrays.asList(nums[t], nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }
}
