package leetcode;

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

    public static void quickSort(int l ,int r) {
        if (l >= r) {
            return;
        }
        int pre = nums[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (nums[j] >= pre && i < j) {
                j--;
            }
            while (nums[i] <= pre && i < j) {
                i++;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        nums[l] = nums[i];
        nums[i] = pre;
        quickSort(l, i - 1);
        quickSort(i + 1, r);
//        Arrays.sort();
    }
}
