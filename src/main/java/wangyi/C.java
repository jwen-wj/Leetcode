package wangyi;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/4
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        long[] diff = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = a[i + 1] - a[i];
        }

        long max = 0;
        long len = 0;
        for (int i = 0; i < n - 1; i++) {
            long num = b[i] + diff[i];
            if (num == b[i + 1]) {
                len++;
                max = Math.max(max, len + 1);
            } else {
                len = 0;
            }
        }

        System.out.println(max);
    }
}
