package huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/24
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(dfs(a, n, m));
    }

    public static int dfs(int[][] a, int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (valid(a, n, m, i, j)) {
                    a[i][j] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static boolean valid(int[][] a, int n, int m,int i, int j) {
        if (a[i][j] == 1) {
            return false;
        }

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                continue;
            }
            if (a[ni][nj] == 1) {
                return false;
            }
        }

        return true;
    }
}
