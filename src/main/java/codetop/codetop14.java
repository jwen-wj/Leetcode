package codetop;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop14 {
    public  int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
