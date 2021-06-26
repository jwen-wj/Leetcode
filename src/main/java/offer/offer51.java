package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer51 {
    int[] nums, temp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        temp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i == m + 1) nums[k] = temp[j++];
            else if (j == r + 1 || temp[i] <= temp[j]) nums[k] = temp[i++];
            else {
                nums[k] = temp[j++];
                res += m - i + 1;
            }
        }
        return res;
    }
}
