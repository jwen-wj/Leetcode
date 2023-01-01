package yongyou;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/9
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            sb.append(s);
            String[] nums = s.split(",");
            m = nums.length;
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        String[] ss = sb.toString().split(",");
        n = ss.length / m;
        int k = 0;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(ss[k++]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    int temp = bfs(a, i, j, n, m);
                    max = Math.max(temp, max);
                }
            }
        }

        System.out.println(max);
    }

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(int[][] a, int x, int y, int n, int m) {
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        a[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = ints[0] + dir[i][0];
                int ny = ints[1] + dir[i][1];
                if (valid(a, nx, ny, n, m)) {
                    a[nx][ny] = 0;
                    res++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return res;
    }

    public static boolean valid(int[][] a, int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 1;
    }
}
