package duxiaoman;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (valid(a,j, i, k)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean valid(int[] a, int l, int r, int k) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        int mod = max % min;
        int dvd = max / min;
        if (mod != 0) {
            return false;
        }
        return dvd == k;
    }
}
