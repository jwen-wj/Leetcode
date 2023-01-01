package dewu;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countWays(n));
    }
    public static int countWays(int n) {
        // write code here
        int mod = (int) 1e9 + 7;
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin] % mod;
            }
        }

        return dp[n];
    }
}
