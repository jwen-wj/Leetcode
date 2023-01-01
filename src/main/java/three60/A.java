package three60;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/27
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            String s = sc.nextLine();
            String w = sc.nextLine();
            int sl = s.length();
            int wl = w.length();
            int l1 = 0, l2 = 0;
            if (sl > wl) {
                System.out.println("NO");
                continue;
            }
            // ab
            // aabba
            while (l1 < sl && l2 < wl) {
                if (s.charAt(l1) == w.charAt(l2)) {
                    l1++;
                    l2++;
                    continue;
                }
                if (l1 == 0) {
                    break;
                }
                if (s.charAt(l1 - 1) != w.charAt(l2)) {
                    break;
                }
                l2++;
            }
            if (l1 == sl) {
                if (l2 == wl) {
                    System.out.println("YES");
                } else {
                    boolean flag = true;
                    for (int i = l2; i < wl; i++) {
                        if (w.charAt(i) != s.charAt(sl - 1)) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}

/**
 * 1e6
 *
 * 4
 * hello
 * hello
 * hello
 * helloo
 * hello
 * hlllloo
 * hello
 * helo
 *
 * YES
 * YES
 * NO
 * NO
 */
