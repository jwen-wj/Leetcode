package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/22
 */

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[2020];
        int len = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < len1 || j < len2) {
            int max = -1;
            if (i < len1 && j < len2) {
                if (nums1[i] > nums2[j]){
                    max = nums2[j++];
                } else {
                    max = nums1[i++];
                }
            } else if (i < len1) {
                max = nums1[i++];
            } else {
                max = nums2[j++];
            }
            nums[len++] = max;
        }
        double ans = 0.0;
        if (len % 2 == 0) {
            ans = (double)(nums[len / 2] + nums[len / 2 - 1]) / 2;
        } else {
            ans = nums[len / 2];
        }
        return ans;
    }
}
