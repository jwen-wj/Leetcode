package intel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/9
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j) && !visited[j]) {
                    map.put(i, j);
                    visited[j] = true;
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            int cnt = 0;
            int k = -1;
            for (int j = i; j < s1.length(); j++) {
                int idx = map.getOrDefault(j, - 1);
                if (idx == -1) {
                    continue;
                }
                if (idx > k) {
                    cnt++;
                    k = idx;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
