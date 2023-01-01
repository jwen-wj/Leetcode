package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/1
 */
public class daily0701 {
    public static void main(String[] args) {
        int n = 5;
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(numWays(n, relation, k));
    }
    public static int numWays(int n, int[][] relation, int k) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
            list.add(ints[1]);
            map.put(ints[0], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            if (step > k) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                if (step == k) {
                    if (pos == n - 1) {
                        result++;
                    }
                }
                List<Integer> list = map.getOrDefault(pos, new ArrayList<>());
                for (Integer next : list) {
                    queue.offer(next);
                }
            }
        }
        return result;
    }
}
