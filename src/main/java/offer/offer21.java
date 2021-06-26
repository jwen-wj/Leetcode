package offer;

import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer21 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        exchange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public static int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 == 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            } else if (nums[l] % 2 == 0) {
                r--;
            } else if (nums[r] % 2 == 1) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return nums;
    }
}
