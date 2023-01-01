package baidu;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] a = new char[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = n * m + 1;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // rd er de
                char now = a[i][j];
                if (i >= 1) {
                    char top = a[i - 1][j];
                    if (valid(top, now)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                }

                if (j >= 1) {
                    char left = a[i][j - 1];
                    if (valid(left, now)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }

                if (i < n - 1) {
                    char bottom = a[i + 1][j];
                    if (valid(bottom, now)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                }

                if (j < m - 1) {
                    char right = a[i][j + 1];
                    if (valid(right, now)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        if (dp[n - 1][m - 1] != n * m + 1) {
            System.out.println(dp[n - 1][m - 1]);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean valid(char f, char e) {
        if (f == 'r' && e == 'd') {
            return false;
        }
        if (f == 'e' && e == 'r') {
            return false;
        }
        if (f == 'd' && e == 'e') {
            return false;
        }
        return true;
    }
}
