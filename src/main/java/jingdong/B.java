package jingdong;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/3
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }

        int[] dp = new int[max + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 2; i <= max; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    int k = i / j;
                    dp[i] = Math.min(dp[i], dp[j] + dp[k] + 1);
                }
            }
        }

        for (int i = 1; i <= max; i++) {
            System.out.printf("dp[%d] = ", i);
            System.out.println(dp[i]);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += dp[a[i]];
        }

        System.out.println(result);
    }
}
