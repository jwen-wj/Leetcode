package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 0, 0};
        int k = 3;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{
            put(0, 1);
        }};
        int pre = nums[0];
        int key = nums[0] % k;
        map.put(key, 1);
        for (int i = 1; i < nums.length; i++) {
            pre = pre + nums[i];
            key = pre % k;
            // 如果当前数字加上之前的数字 % k == 0，说明前缀和是k的倍数。
            if (map.containsKey(key) && i - map.get(key) >= 2) {
                return true;
            }
            map.put(key, i);
        }
        return false;
    }
}
