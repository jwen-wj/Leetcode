package daily;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/14
 */

public class daily0714 {
    int[] sorted;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int mod = (int)1e9 + 7;
        int n = nums1.length;
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums1[i];
        }
        Arrays.sort(sorted);
        int maxn = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (diff + sum) % mod;
            int index = search(0, n - 1, nums2[i]);
            if (index > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - sorted[index - 1]));
            }

            if (index < n) {
                maxn = Math.max(maxn, diff - (sorted[index] - nums2[i]));
            }
        }
        return (sum - maxn + mod) % mod;
    }

    // 获得大于 target 的最小 index
    public int search(int l, int r, int target) {
        if (sorted[r] < target) return r + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sorted[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
