package weizhong;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            sc.nextLine();
            long max = Math.max(a, b);
            long min = Math.min(a, b);
            if (max == min) {
                System.out.println(2);
                continue;
            }
            if (max % min != 0) {
                System.out.println(-1);
                continue;
            }
            long target = max / min;
            if ((target & target - 1) != 0) {
                System.out.println(-1);
                continue;
            }
            long cnt = 0;
            while (target != 0) {
                if (target % 8L != 0) {
                    break;
                }
                target /= 8L;
                cnt++;
            }
            while (target != 0) {
                if (target % 4L != 0) {
                    break;
                }
                target /= 4L;
                cnt++;
            }
            while (target != 0) {
                if (target % 2L != 0) {
                    break;
                }
                target /= 2L;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}

/**
 * 4
 * 3 6
 * 16 2
 * 12 4
 * 1024 1
 */
