package didi;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/4
 */

public class B {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] t = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, Math.min(l[i], r[i]));
            max = Math.max(max, Math.max(l[i], r[i]));
        }

        init(min, max);

        for (int i = 0; i < n; i++) {
            int L = l[i];
            int R = r[i];
            int T = t[i];
            List<Integer> list = map.getOrDefault(T, new ArrayList<>());
            int cnt = 0;
            for (Integer integer : list) {
                int k = integer;
                if (L <= k && k <= R) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (i != n - 1) {
                System.out.printf("%d ", cnt);
            } else {
                System.out.println(cnt);
            }
        }
    }

    public static void init(int l, int r) {
        for (int i = l; i <= r; i++) {
            int t = 0;
            int k = i;
            while (k != 0) {
                t ^= k % 10;
                k /= 10;
            }
            List<Integer> list = map.getOrDefault(t, new ArrayList<>());
            list.add(i);
            map.put(t, list);
        }
    }
}
