package mayi;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/15
 */

public class B {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static long res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            map.put(i + 1, new LinkedList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            map.get(s).add(e);
            map.get(e).add(s);
        }
        dfs(1, 0);
        System.out.println(res);
    }

    public static void dfs(int root, int pre) {
        res += root - pre - 1;
        visited[root] = true;
        for (Integer x : map.get(root)) {
            if (visited[x]) {
                continue;
            }
            visited[x] = true;
            dfs(x, root - 1);
        }
    }
}

