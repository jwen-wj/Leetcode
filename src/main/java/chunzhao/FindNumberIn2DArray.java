package chunzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/11/22
 */

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int i = n;
        int j = 0;
        while (0 <= i && i <= n && 0 <= j && j <= m) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            }
            if (num < target) {
                j++;
            }
            if (num > target) {
                i--;
            }
        }

        return false;
    }
}
