package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/5
 */

public class daily0704 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 0) result[1] = i;
            if (map.getOrDefault(i, 0) == 2) result[0] = i;
        }
        return result;
    }
}
