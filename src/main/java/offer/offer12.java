package offer;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer12 {

    public boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char old = board[x][y];
        board[x][y] = '\0';
        boolean flag = dfs(board, word, x + 1, y, k + 1) ||
                dfs(board, word, x , y + 1, k + 1) ||
                dfs(board, word, x - 1, y, k + 1) ||
                dfs(board, word, x, y - 1, k + 1);
        board[x][y] = old;
        return flag;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
