package daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/24
 */
public class daily0624 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points));
    }
    public static int maxPoints(int[][] points) {
        int max = 1;
        int m = points.length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int a = points[j][1] - points[i][1];
                int b = points[i][0] - points[j][0];
                int c = -1 * (a * points[i][0] + b * points[i][1]);
                int num = 0;
                for (int k = 0; k < m; k++) {
                    if (a * points[k][0] + b * points[k][1] + c == 0) num++;
                }
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
