package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1, 4, 6};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; i--) {
            swap(nums, 0, i);
            len--;
            maxHeapify(nums, 0, len);
        }
    }

    public static void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    public static void maxHeapify(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
