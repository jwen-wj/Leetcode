package tianyiyun2;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/16
 */

public class A {
    static char[] paint;
    static Map<Integer, List<Integer>> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            List<Integer> listu = map.get(u);
            List<Integer> listv = map.get(v);
            listu.add(v);
            listv.add(u);
            map.put(u, listu);
            map.put(v, listv);
            sc.nextLine();
        }

        paint = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            if (map.get(i).size() > 2) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (map.get(i).size() == 1) {
                paint[i] = 'R';
                dfs(i, map.get(i));
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(paint[i]);
        }
        System.out.println();
    }

    public static void dfs(int u, List<Integer> listv) {
        Integer num1 = listv.get(0);
        if (listv.size() == 1) {
            if (paint[num1] != 'R' && paint[num1] != 'B') {
                paint[num1] = paint[u];
                dfs(num1, map.get(num1));
            }
            return;
        }
        Integer num2 = listv.get(1);
        if (paint[num1] != 'R' && paint[num1] != 'B') {
            paint[num1] = 'R';
            dfs(num1, map.get(num1));
        }
        if (paint[num2] != 'R' && paint[num2] != 'B') {
            paint[num2] = 'B';
            dfs(num2, map.get(num2));
        }
    }
}
