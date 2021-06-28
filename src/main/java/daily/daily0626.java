package daily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/26
 */

public class daily0626 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{4, 1, 2}, {5, 0, 3}};
        System.out.println(slidingPuzzle(board));
    }
    static Set<String> passed = new HashSet<>();
    static Queue<int[][]> queue = new LinkedList<>();
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int slidingPuzzle(int[][] board) {
        queue.add(newArray(board));
        passed.add(getStatus(board));
        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[][] now = newArray(queue.poll());
                String status = getStatus(now);
                if ("123450".equals(status)) return step;
                int x = 0, y = 0;
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (now[j][k] == 0) {
                            x = j;
                            y = k;
                            break;
                        }
                    }
                }
                for (int j = 0; j < 4; j++) {
                    int swapX = x + dir[j][0];
                    int swapY = y + dir[j][1];
                    int[][] next = newArray(now);
                    if (swapX >= 0 && swapX < 2 && swapY >= 0 && swapY < 3) {
                        int[][] swaped = newArray(next);
                        int temp = swaped[swapX][swapY];
                        swaped[swapX][swapY] = swaped[x][y];
                        swaped[x][y] = temp;
                        String result = getStatus(swaped);
                        if (!passed.contains(result)) {
                            queue.offer(newArray(swaped));
                            passed.add(result);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int[][] newArray(int[][] board) {
        int[][] result = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }
    public static String getStatus(int[][] board) {
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                string.append(board[i][j]);
            }
        }
        return string.toString();
    }
}
