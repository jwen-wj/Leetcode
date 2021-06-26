package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            while (nums[fast] == val && fast < n) {
                fast++;
            }
            slow++;
            if (fast < n) {
                nums[slow] = nums[fast];
            }
        }
        return slow;
    }
}
