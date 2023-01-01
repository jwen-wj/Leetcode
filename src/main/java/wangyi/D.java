package wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/4
 */

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] pre = new int[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + a[i] + 1;
        }

        int space = w - pre[n - 1];
        int cnt = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (space > a[i]) {
                continue;
            }
            int l = pre[i] - a[i] + space;
            int r = pre[i];
            cnt += r - l;
            list.add(new int[]{l, r});
        }

        System.out.println(cnt);
        for (int[] ints : list) {
            int l = ints[0];
            int r = ints[1];
            for (int i = l + 1; i <= r; i++) {
                cnt--;
                if (cnt != 0) {
                    System.out.printf("%d ", i);
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}
