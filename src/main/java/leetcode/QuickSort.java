package leetcode;

import java.util.Random;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class QuickSort {
    static int[] nums = new int[]{2, 3, 1, 6, 5, 4};

    public static void main(String[] args) {
        quickSort(0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int idx = partition(l, r);
        quickSort(l, idx - 1);
        quickSort(idx + 1, r);
    }

    public static int partition(int l, int r) {
        int idx = new Random().nextInt(r - l) + 1 + l;
        int pivot = nums[idx];
        int pre = l;
        swap(l, idx);
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            while (l < r && nums[l] <= pivot) l++;
            swap(l, r);
        }
        swap(pre, l);
        return l;
    }

    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
