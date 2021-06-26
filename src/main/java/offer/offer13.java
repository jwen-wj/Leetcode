package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y =y;
    }
}
public class offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        result++;
        used[0][0] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dir[i][0];
                int nextY = now.y + dir[i][1];
                if (isValid(nextX, nextY, m, n, used, k)) {
                    queue.offer(new Point(nextX, nextY));
                    used[nextX][nextY] = true;
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isValid(int nextX, int nextY, int m, int n, boolean[][] used, int k) {
        if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || used[nextX][nextY]) {
            return false;
        }
        int sum = 0;
        int x = nextX;
        int y = nextY;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        if (sum > k) {
            return false;
        }
        return true;
    }
}
