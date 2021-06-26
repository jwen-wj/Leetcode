package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/6
 */

public class offer47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
