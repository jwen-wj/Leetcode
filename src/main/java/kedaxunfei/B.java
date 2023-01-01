package kedaxunfei;

import com.sun.tools.doclets.internal.toolkit.AnnotationTypeOptionalMemberWriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/17
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] before = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                before[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] after = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                after[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        boolean[][] not_modify = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] == after[i][j]) {
                    not_modify[i][j] = true;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (not_modify[i][j]) {
                    max = Math.max(max, bfs(not_modify, i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int bfs(boolean[][] not_modify, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        not_modify[x][y] = false;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] xys = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xys[0] + dir[i][0];
                int ny = xys[1] + dir[i][1];
                if (valid(not_modify, nx, ny)) {
                    queue.add(new int[]{nx, ny});
                    not_modify[nx][ny] = false;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static boolean valid(boolean[][] not_modify, int x, int y) {
        int n = not_modify.length;
        int m = not_modify[0].length;
        return 0 <= x && x < n && 0 <= y && y < m && not_modify[x][y];
    }
}
