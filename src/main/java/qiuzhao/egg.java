package qiuzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/21
 */

public class egg {
    static int res = 101;
    static int[][] mem = new int[3][101];
    public static void main(String[] args) {
        System.out.println(dfs(2, 100));
    }

    public static int dfs(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (mem[k][n] != 0) {
            return mem[k][n];
        }

        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(dfs(k - 1, i - 1), dfs(k, n - i)) + 1);
        }

        mem[k][n] = res;

        return res;
    }
}
