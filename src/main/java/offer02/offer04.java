package offer02;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n <= 0) return false;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
            else return true;
        }
        return false;
    }
}
