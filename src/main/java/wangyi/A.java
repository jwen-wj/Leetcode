package wangyi;

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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(a[0]);
            return;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, Math.abs(a[i] - a[i + 1]));
        }
        System.out.println(min);
    }
}
