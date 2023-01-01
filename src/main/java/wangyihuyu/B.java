package wangyihuyu;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/27
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][4];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    a[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            int maxX = 0;
            int maxY = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    int x1 = a[i][0];
                    int y1 = a[i][1];
                    int x2 = a[i][2];
                    int y2 = a[i][3];
                    maxX = Math.max(maxX, Math.max(x1, x2));
                    maxY = Math.max(maxY, Math.max(y1, y2));
                }
            }
            int[][] paint = new int[maxX][maxY];
            for (int i = 0; i < n; i++) {
                int x1 = a[i][0];
                int y1 = a[i][1];
                int x2 = a[i][2];
                int y2 = a[i][3];
                fill(paint, x1, x2, y1, y2);
            }

            long result = count(paint);
            System.out.println(result);
        }
    }

    public static long count(int[][] paint) {
        int n = paint.length;
        int m = paint[0].length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paint[i][j] >= 1) {
                    result += bfs(paint, i, j);
                }
            }
        }

        return result;
    }

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static long bfs(int[][] paint, int x, int y) {
        boolean connect = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int result = 1;
        if (paint[x][y] > 1) {
            connect = true;
        }
        paint[x][y] = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dir[i][0];
                int nextY = now[1] + dir[i][1];
                if (valid(paint, nextX, nextY)) {
                    result++;
                    if (paint[nextX][nextY] > 1) {
                        connect = true;
                    }
                    paint[nextX][nextY] = -1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return connect ? result : 0;
    }

    public static boolean valid(int[][] paint, int x, int y) {
        int n = paint.length;
        int m = paint[0].length;
        return x >= 0 && x < n && y >= 0 && y < m && paint[x][y] >= 1;
    }

    public static void fill(int[][] paint, int x1, int x2, int y1, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                paint[i][j]++;
            }
        }
    }
}
