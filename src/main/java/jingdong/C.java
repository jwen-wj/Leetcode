package jingdong;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/3
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != max) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
