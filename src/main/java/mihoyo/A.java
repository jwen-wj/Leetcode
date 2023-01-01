package mihoyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/14
 */

public class A {
    static List<int[]> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if (s.length() < 6) {
            System.out.println(-1);
            return;
        }
        count(s);
        if (res.size() < k) {
            System.out.println(-1);
            return;
        }
        int L = 0;
        int R = 0;
        int size = res.size();
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int j = i + k - 1;
            if (j >= size) {
                break;
            }
            if (res.get(j)[1] - res.get(i)[0] < len) {
                L = res.get(i)[0];
                R = res.get(j)[1];
                len = R - L;
            }
        }
        System.out.printf("%d %d\n", L, R);
    }

    public static void count(String s) {
        String mihoyo = "mihoyo";
        for (int i = 0; i <= s.length() - 6; i++) {
            String temp = s.substring(i, i + 6);
            if (temp.equals(mihoyo)) {
                res.add(new int[]{i, i + 5});
            }
        }
    }
}
