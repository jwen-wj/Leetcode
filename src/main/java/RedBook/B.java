package RedBook;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/28
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
//        3 3
//        1 2 3
//        4
        // 1 2 3 4 5
        Arrays.sort(a);
        int l = 0;
        int r = n - 1;
        long result = 0;
        while (l < r) {
            long multi = (long) a[l] * a[r];
            if (multi >= k) {
                result = result + (r - l) * 2L;
                r--;
            } else {
                l++;
            }
        }
        System.out.println(result);
    }
}
