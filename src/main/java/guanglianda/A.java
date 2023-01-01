package guanglianda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] s = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        // 5
        // 5 4 3 2 1
        // 1 5 3 4 2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s[i], i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > map.get(p[i])) {
                max = Math.max(max, i - map.get(p[i]));
            }
        }

        int l = 0;
        Stack<Integer> stack = new Stack<>();
        while (l < n) {
            while (!stack.empty() && stack.peek() > map.get(p[l])) {
                stack.pop();
            }
            stack.add(map.get(p[l++]));
        }

        System.out.println(n - stack.size());
    }
}


