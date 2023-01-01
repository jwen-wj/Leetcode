package offer02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer12 {
    char[][] board;
    String word;
    public boolean dfs(int x, int y, int k) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;

        char ch = board[x][y];
        board[x][y] = '\0';
        boolean result = dfs(x + 1, y, k + 1) || dfs(x - 1, y, k + 1)
                || dfs(x, y + 1, k + 1) || dfs(x, y - 1, k + 1);
        board[x][y] = ch;
        return result;
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }
}
