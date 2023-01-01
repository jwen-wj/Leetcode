package codetop;

/**
 * @description:
 * @author: jwen
 * @date: 2022/3/2
 */

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 1;
        int res = 1;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] <= tails[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            tails[left] = nums[i];
            if (left >= len) {
                len++;
            }
            res = Math.max(res, len);
        }

        return res;
    }
}
