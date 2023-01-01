package qianxin;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/25
 */

public class A {
    static int cnt = 0;

    public static int DagPathNum (int[][] nodes) {
        // write code here
        dfs(nodes, 0);
        return cnt;
    }

    public static void dfs(int[][] node, int x) {
        Map<Integer, Integer> map = new HashMap();
        for (int nextX : node[x]) {
            if (map.containsKey(nextX)) {
                continue;
            }
            map.put(nextX, 1);
            if (nextX == 4) {
                cnt++;
            } else if (nextX != 0) {
                dfs(node, nextX);
            }
        }
    }
}
