package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/9
 */

public class daily0709 {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            if (candidate == num) count++;
            else count--;
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        return count * 2 > nums.length ? candidate : -1;
    }
}
