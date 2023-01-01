package mihoyo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/14
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        int upper = sc.nextInt();
        int lower = sc.nextInt();

        Arrays.sort(a);

        if (lower == n) {
            System.out.println("infinity");
            return;
        }
        int L = a[lower - 1];
        int R = a[lower];
        System.out.println(R - L);
    }
}
