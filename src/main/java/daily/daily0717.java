package daily;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class daily0717 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxn = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxn = Math.max(sum, maxn);
            if (sum < 0) sum = 0;
        }
        return maxn;
    }
}
