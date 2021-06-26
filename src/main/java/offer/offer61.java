package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = -1;
        int countZero = 0;
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
                max = Math.max(max, num);
                min = Math.min(min, num);
            } else {
                countZero++;
            }
        }
        if (set.size() + countZero == 5 && max - min < 5) {
            return true;
        }
        return false;
    }
}
