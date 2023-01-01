package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/24
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(a);
        long[] dp = new long[m + 1];
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1] + a[i - 1];
        }

        int max = 1;
        long ln = n;
        long res = n;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < i; j++) {
                long num = (long) a[i - 1] * (long) (i - j + 1) - (dp[i] - dp[j - 1]);
                if (num > ln) {
                    continue;
                }
                int cnt = i - j + 1;
                if (cnt >= max) {
                    max = Math.max(i - j + 1, max);
                    res = Math.min(res, ln - num);
                }
            }
        }

        System.out.printf("%d %d\n", max, res);
    }
}
