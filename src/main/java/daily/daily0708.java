package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/8
 */

public class daily0708 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int pre = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            pre += nums[i];
            result += map.getOrDefault(pre - goal, 0);
        }
        return result;
    }
}
