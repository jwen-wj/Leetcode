package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/2
 */

public class ArraySearch {
    public static void main(String[] args) {
        ArraySearch as = new ArraySearch();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(as.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int l = L;
        int r = R;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            // 在左半区
            if (nums[L] <= nums[m]) {
                // 在左半区的左侧
                if (nums[L] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else { // 在右半区
                if (nums[m] < target && target <= nums[R]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
