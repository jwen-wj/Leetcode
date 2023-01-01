package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/16
 */

public class daily0716 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
