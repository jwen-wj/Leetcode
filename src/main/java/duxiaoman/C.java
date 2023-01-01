package duxiaoman;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long mod = (long) 1e9 + 7;
        a[0] = 9;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] * 9L % mod;
        }
        long[] dp = new long[n];
//        int temp = deal();
//        System.out.println(temp);

        if (n == 1) {
            System.out.println(a[0]);
            return;
        }
        if (n == 2) {
            System.out.println(a[1] - 1);
            System.out.println();
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 25;
        // 225 + 81 * 17
        // 1602
        // 353
        for (int i = 3; i < n; i++) {
            // 当前不为1的情况
            // xxxxx = 25 * 8 = 200
            dp[i] = (dp[i - 1] * 8L) % mod;
            // 当前为1的情况
            // xx111 xxx11 xx1x1 = 17 * 9 = 153
            dp[i] += a[i - 3] * 17L % mod;
            // xxxx1
            dp[i] += dp[i - 3] * 64L % mod;
            // 4265
            // 353 * 8 = 2824
            // 81 * 17 = 1377
            // 2824 + 1377 = 4201
        }
        long result = (a[n - 1] + mod - dp[n - 1]) % mod;

        System.out.println(result);
    }

    public static int deal() {
        int N = (int) 1e5 + 10;
        String[] str = new String[N];
        int len = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        for (int m = 1; m <= 9; m++) {
                            StringBuffer sb = new StringBuffer();
                            sb.append(i);
                            sb.append(j);
                            sb.append(k);
                            sb.append(l);
                            sb.append(m);
                            str[len++] = sb.toString();
                        }
                    }
                }
            }
        }

        int cnt = 0;
        String[] res = new String[N];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 5; j++) {
                if (j > 0 && str[i].charAt(j) == '1' && str[i].charAt(j - 1) == '1') {
                    res[cnt++] = str[i];
                }
                if (j > 1 && str[i].charAt(j) == '1' && str[i].charAt(j - 2) == '1') {
                    res[cnt++] = str[i];
                }
            }
        }

        Set<String> sets = new HashSet<>();
        for (int i = 0; i < cnt; i++) {
            if (!sets.contains(res[i])) {
                sets.add(res[i]);
            }
        }

        return sets.size();
    }
}
