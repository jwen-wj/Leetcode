package pinduoduo;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/19
 */

public class Eggs {
    static int[][] dp = new int[3][101];
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

        if (dp[k][n] != 0) {
            return dp[k][n];
        }

        int res = Integer.MAX_VALUE;
        for (int j = 1; j < n + 1; j++) {
            res = Math.min(res, Math.max(dfs(k, n - j), dfs(k - 1, j - 1)) + 1);
        }

        dp[k][n] = res;

        return res;
    }
}
