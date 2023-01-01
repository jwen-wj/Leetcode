package chunzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/11/22
 */

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        // 2, 3, 1, 0, 2, 5, 3
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            int j = nums[i];
            if (nums[j] == nums[i]) {
                return nums[i];
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}
