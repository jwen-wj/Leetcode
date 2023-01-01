package qiuzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/29
 */

public class FindKthElement {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 != 0) {
            int k = len / 2;
            return findKthElement(nums1, nums2, k + 1);
        } else {
            int k1 = len / 2 - 1;
            int k2 = len / 2;
            int num1 = findKthElement(nums1, nums2, k1 + 1);
            int num2 = findKthElement(nums1, nums2, k2 + 1);
            return (double) (num1 + num2) / 2.0;
        }
    }

    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, len1) - 1;
            int newIdx2 = Math.min(idx2 + half, len2) - 1;
            int pivot1 = nums1[newIdx1];
            int pivot2 = nums2[newIdx2];
            if (pivot1 <= pivot2) {
                k -= newIdx1 - idx1 + 1;
                idx1 = newIdx1 + 1;
            } else {
                k -= newIdx2 - idx2 + 1;
                idx2 = newIdx2 + 1;
            }
        }
    }
}