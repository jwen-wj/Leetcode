package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/26
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = len - 1;
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (nums[i] + nums[j] + nums[k] == 0 && j != k) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return result;
    }
}
/**
 * [-1,0,1,2,-1,-4]
 * [-4,-1,-1,0,1,2]
 */