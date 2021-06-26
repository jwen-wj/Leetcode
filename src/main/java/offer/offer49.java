package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[p2] * 2;
            int num2 = dp[p3] * 3;
            int num3 = dp[p5] * 5;
            int min = Math.min(num1, Math.min(num2, num3));
            dp[i] = min;
            if (min == num1) p2++;
            if (min == num2) p3++;
            if (min == num3) p5++;
        }
        return dp[n];
    }
}
