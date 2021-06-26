package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/29
 */

public class NumSubmatrixSumTarget {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
//        int[][] matrix = new int[][]{{1, -1}, {-1, 1}};
//        int[][] matrix = new int[][]{
//                {0, 1, 2, 3},
//                {1, 5, -1, 0},
//                {2, 0, -2, -3},
//                {3, 6, -5, 4}
//        };
        int[][] matrix = new int[][]{
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0}
        };
//        System.out.println(numSubmatrixSumTarget(matrix, 1));
        System.out.println(numSubmatrixSumTarget_best(matrix, 1));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result = 0;
        long[][] area = new long[101][101];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                area[i][j] = ((i - 1) >= 0 ? area[i - 1][j] : 0)
                        + ((j - 1) >= 0 ? area[i][j - 1] : 0)
                        - (((i - 1) >= 0 && (j - 1) >= 0) ? area[i - 1][j - 1] : 0)
                        + matrix[i][j];
            }
        }
//        // 打印前缀和矩阵
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(area[i][j] + " ");
//            }
//            System.out.println();
//        }
//        long temp = area[2][2] - area[2][1] - area[1][2] + area[1][1];
//        System.out.println(temp);
        for (int x1 = 0; x1 < matrix.length; x1++) {
            for (int y1 = 0; y1 < matrix[0].length; y1++) {
                for (int x2 = 0; x2 < matrix.length; x2++) {
                    for (int y2 = 0; y2 < matrix[0].length; y2++) {
                        if (x2 >= x1 && y2 >= y1) {
                            long area_x1_y1_x2_y2 = area[x2][y2]
                                    - ((x1 - 1 >= 0) ? area[x1 - 1][y2] : 0)
                                    - ((y1 - 1 >= 0) ? area[x2][y1 - 1] : 0)
                                    + (((x1 - 1) >= 0 && (y1 - 1) >= 0) ? area[x1 - 1][y1 - 1] : 0);
                            if (area_x1_y1_x2_y2 == target) {
//                                System.out.print("(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")");
//                                System.out.println();
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int numSubmatrixSumTarget_best(int[][] matrix, int target) {
        int result = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) { // 枚举第 i 行
            int[] sum = new int[col];
            for (int j = i; j < row; j++) { // 枚举第 j 行
                for (int k = 0; k < col; k++) { // 统计每列的总和
                    sum[k] += matrix[j][k];
                }
                result += subArray(sum, target);
            }
        }
        return result;
    }

    public static int subArray(int[] sum, int target) {
        int pre = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < sum.length; i++) {
            pre += sum[i];
            if (map.containsKey(pre - target)) {
                result += map.get(pre - target);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return result;
    }
}
