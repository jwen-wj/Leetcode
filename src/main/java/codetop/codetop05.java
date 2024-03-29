package codetop;

import com.apple.laf.AquaEditorPaneUI;

import java.util.Random;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class codetop05 {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums,0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int i = l - 1;
        int pivot = nums[r];
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
