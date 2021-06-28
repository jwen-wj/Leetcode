package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/28
 */

public class daily0628 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        boolean[][] edge = new boolean[n + 1][n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 建图，根据点去找边之间是否相连
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = map.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                map.put(site, list);
            }
        }
        int[] dis = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(dis, -1);
        for (int site : map.getOrDefault(source, new ArrayList<>())) {
            dis[site] = 1;
            queue.offer(site);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int site : map.getOrDefault(target, new ArrayList<>())) {
            if (dis[site] != -1) result = Math.min(result, dis[site]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
