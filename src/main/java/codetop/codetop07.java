package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop07 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(target - nums[j])) {
                int i = map.get(target - nums[j]);
                return new int[]{i, j};
            }
            map.put(nums[j], j);
        }
        return new int[]{-1, -1};
    }
}
