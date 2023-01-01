package tianyiyun2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/16
 */

public class C {
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static char[][] paint;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        paint = new char[n][m];
        visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                paint[i][j] = str.charAt(j);
            }
        }

        bfs(h);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void bfs(int h) {
        int n = paint.length - 1;
        int m = paint[0].length - 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, h));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == n && now.y == m) {
                min = Math.min(min, now.step);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dir[i][0];
                int nextY = now.y + dir[i][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (paint[nextX][nextY] == '.'){
                        queue.add(new Node(nextX, nextY, now.step + 1, now.h));
                        paint[nextX][nextY] = '-';
                    } else if (Character.isDigit(paint[nextX][nextY])) {
                        int mm = paint[nextX][nextY] - '0';
                        if (now.h > mm) {
                            queue.add(new Node(nextX, nextY, now.step + 1, now.h - mm));
                            paint[nextX][nextY] = '-';
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int step;
    int h;
    Node(int _x, int _y, int _step, int _h) {
        x = _x;
        y = _y;
        step = _step;
        h = _h;
    }
}
