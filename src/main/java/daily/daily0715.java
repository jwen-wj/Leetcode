package daily;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/15
 */

public class daily0715 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        int miss = 0;
        for (int num : arr) {
            cnt[Math.min(num, n)]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                miss++;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return Math.min(n - miss, n);
    }
}
