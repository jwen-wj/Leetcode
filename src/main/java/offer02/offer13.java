package offer02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer13 {

    class Point {
        int x, y;
        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public int movingCount(int m, int n, int k) {
        int sum = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] passed = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        passed[0][0] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dir[i][0];
                int nextY = now.y + dir[i][1];
                if (cal(nextX, nextY, k) && nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !passed[nextX][nextY]) {
                    sum++;
                    queue.offer(new Point(nextX, nextY));
                    passed[nextX][nextY] = true;
                }
            }
        }
        return sum;
    }

    public boolean cal(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
