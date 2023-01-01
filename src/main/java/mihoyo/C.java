package mihoyo;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/14
 */

public class C {
    static boolean[] visited;
    static List<List<Integer>> list;
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        sc.nextLine();

        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            list.get(s).add(e);
            list.get(e).add(s);
        }

        dfs(r);
        System.out.println(res);
    }

    public static int dfs(int root) {
        int cnt = 1;
        visited[root] = true;
        for (Integer next : list.get(root)) {
            if (!visited[next]) {
                int x = dfs(next);
                cnt += x;
                if (next % 2 == root % 2) {
                    cnt--;
                }
            }
        }
        res += cnt;

        return cnt;
    }
}
