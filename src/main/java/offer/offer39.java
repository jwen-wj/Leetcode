package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/5
 */

public class offer39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) * 2 > length) {
                max = key;
                break;
            }
        }
        return max;
    }

    public int majorityElement_better(int[] nums) {
        int votes = 0;
        int max = -1;
        for (int num : nums) {
            if (votes == 0) {
                max = num;
            }
            votes = votes + (max == num ? 1 : -1);
        }
        return max;
    }
}
