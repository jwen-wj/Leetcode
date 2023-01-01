package gaotu;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/29
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean result = valid(a, b, c) && valid(a, c, b) && valid(b, c, a);
        System.out.println(result);
    }

    public static boolean valid(int a, int b, int c) {
        int left = Math.abs(a - b);
        int right = a + b;
        return left < c && c < right;
    }
}
