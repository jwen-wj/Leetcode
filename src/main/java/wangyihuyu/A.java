package wangyihuyu;

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
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] p = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    char ch = s.charAt(j);
                    p[i][j] = ch;
                }
            }
            int x = (m - n) / 2;
            int mod = x % n;
            int y = mod == 0 ? x / n : x / n + 1;
            int L = (y * 2 + 1) * n;
            char[][] result = new char[L][L];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    int pi = i % n;
                    int pj = j % n;
                    result[i][j] = p[pi][pj];
                }
            }
            //int diff = n - (m - n) / 2;
            int diff = (L - m) / 2;
            for (int i = diff; i < L - diff; i++) {
                for (int j = diff; j < L - diff; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
            System.out.println();

//            sc.nextLine();
        }
    }
}
