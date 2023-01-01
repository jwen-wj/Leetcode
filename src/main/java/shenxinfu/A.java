package shenxinfu;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/1
 */

public class A {
    public int ncov_defect (int[][] grid) {
        // write code here
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    spread(grid, i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void spread(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                grid[x][y] = -1;
            }
        }
    }
}
