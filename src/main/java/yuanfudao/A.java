package yuanfudao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/26
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            String word = sc.nextLine();
            String stop = sc.nextLine();
            String[] word_splits = word.split(" ");
            String[] stop_splits = stop.split(" ");
            int n = word_splits.length;
            int m = stop_splits.length;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                String w = word_splits[i];
                w = w.toLowerCase();
                boolean exist_in_stop = false;
                for (int j = 1; j < m; j++) {
                    String s = stop_splits[j];
                    s = s.toLowerCase();
                    if (isStop(w, s)) {
                        exist_in_stop = true;
                    }
                }
                if (!exist_in_stop) {
                    map.put(w, map.getOrDefault(w, 0) + 1);
                }
            }

            int max = 0;
            for (String s : map.keySet()) {
                max = Math.max(max, map.get(s));
            }

            System.out.println(max);
        }
    }

    public static boolean isStop(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c2 == '?') {
                continue;
            }
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
