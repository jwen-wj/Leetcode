package mayi;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/15
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int res = 0;
        int[][] dp = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            int num = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                dp[i][j] = j == num ? dp[i - 1][j] + 1 : dp[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 26; k++) {
                    if ((dp[j + 1][k] - dp[i][k]) % 2 == 1) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    //System.out.println(s.substring(i, j + 1));
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static boolean valid(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            cnt[num]++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                res ++;
            }
        }
        return res == 1;
    }
}

