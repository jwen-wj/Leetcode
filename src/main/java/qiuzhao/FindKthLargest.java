package qiuzhao;

import java.util.Random;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/19
 */

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 输入: [3,2,1,5,6,4], k = 2
        // 输出: 5
        return quickSort(nums, nums.length - k, 0, nums.length - 1);
    }

    public int quickSort(int[] nums, int k, int l, int r) {
        int result = partition(nums, l, r);
        if (result == k) {
            return nums[result];
        }
        return result < k ? quickSort(nums, k, result + 1, r) : quickSort(nums, k, l, result - 1);
    }

    public int partition(int[] nums, int l, int r) {
        if (l >= r) {
            return l;
        }
        int idx = new Random().nextInt(r - l) + l + 1;
        swap(nums, l, idx);
        int pivot = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, l);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
