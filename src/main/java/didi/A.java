package didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/4
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        long[] pre = new long[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + a[i];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int l = search(a, pre, i, k);
            int len = i - l + 1;
            result = Math.max(result, len);
        }

        System.out.println(result);
    }

    public static int search(int[] a, long[] pre, int r, int k) {
        int l = 0;
        int R = r;
        long ai = a[r];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sum = pre[R] - pre[mid] + a[mid];
            int len = R - mid + 1;
            long x = ai * len;
            long y = sum * k;
            if (y >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
