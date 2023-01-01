package duxiaoman;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            sc.nextLine();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            boolean result = dfs(a, 0, 0, x, a[0][0]);
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean dfs(int[][] a, int i, int j, int x, int sum) {
        if (i == a.length - 1 && j == a[0].length - 1) {
            return sum == x;
        }
        boolean exist = false;
        if (i + 1 < a.length) {
            exist = dfs(a, i + 1, j, x, sum + a[i + 1][j]);
        }
        if (j + 1 < a[0].length) {
            exist |= dfs(a, i, j + 1, x, sum + a[i][j + 1]);
        }
        return exist;
    }
}
