package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class leetcode525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            pre = pre + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(pre)) {
                max = Math.max(max, i - map.get(pre));
            } else {
                map.put(pre, i);
            }
        }
        return max;
    }
}
