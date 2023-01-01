package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1, 4, 6};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[cnt++] = nums[i++];
            } else {
                temp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[cnt++] = nums[i++];
        }
        while (j <= right) {
            temp[cnt++] = nums[j++];
        }

        for (int k = 0; k <= right - left; k++) {
            nums[left + k] = temp[k];
        }
    }
}
