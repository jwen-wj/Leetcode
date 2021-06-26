package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/4
 */

public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return (new int[0]);
        }
        int n = matrix[0].length;
        int sum = m * n;
        int[] result = new int[m * n];
        int i = 0, j = 0;
        int len = 0;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        // 方向： 0 -> 左, 1 -> 下, 2 -> 左, 3 -> 下
        int dir = 0;
        while (len != sum) {
            result[len++] = matrix[i][j];
            if (dir == 0) {
                if (j == right) {
                    i++;
                    dir = (dir + 1) % 4;
                    top++;
                } else {
                    j++;
                }
            } else if (dir == 1) {
                if (i == bottom) {
                    j--;
                    dir = (dir + 1) % 4;
                    right--;
                } else {
                    i++;
                }
            } else if (dir == 2) {
                if (j == left) {
                    i--;
                    dir = (dir + 1) % 4;
                    bottom--;
                } else {
                    j--;
                }
            } else if (dir == 3) {
                if (i == top) {
                    j++;
                    dir = (dir + 1) % 4;
                    left++;
                } else {
                    i--;
                }
            }
        }
        return result;
    }
}
