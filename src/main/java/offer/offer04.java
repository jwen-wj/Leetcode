package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix[0].length;
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        while (i < n && j < m) {
            if (target < matrix[i][j]) i--;
            else if (target > matrix[i][j]) j++;
            else return true;
        }
        return false;
    }
}
