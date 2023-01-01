package pinduoduo;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/3
 */

public class B {
    static int[] visited;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] a = new int[n];
            visited = new int[n];
            dp = new int[n];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                String[] ss = s.split(" ");
                int num = Integer.parseInt(ss[1]);
                if ("L".equals(ss[0])) {
                    a[i] = -num;
                } else {
                    a[i] = num;
                }
            }

            for (int i = 0; i < n; i++) {
                int result = dfs(a, n, i, 0);
                System.out.print(result);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static int dfs(int[] a, int n, int i, int cnt) {
        if (i < 0 || i >= n) {
            return cnt;
        }

        if (visited[i] == 1) {
            return -1;
        }
        if (dp[i] != 0) {
            if (dp[i] == -1) {
                return -1;
            }
            return dp[i] + cnt;
        }

        visited[i] = 1;
        int result = dfs(a, n, i + a[i], cnt + 1);
        visited[i] = 0;
        if (result == -1) {
            dp[i] = -1;
        } else {
            dp[i] = result - cnt;
        }

        return result;
    }
}
