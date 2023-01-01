package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/7
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1 2 5 4 3
        // 从后往前找到第一个不递增的数 2
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 从后往前找到第一个大于 2 的数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
