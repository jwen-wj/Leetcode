package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0;
        int fast = 1;
        int n = nums.length;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
