package daily;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/2
 */

public class daily0702 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            if (sum + costs[i] <= coins) {
                result++;
                sum += costs[i];
            }
        }
        return result;
    }
}
