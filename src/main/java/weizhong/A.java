package weizhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String content = sc.nextLine();
        String[] splits = content.split(" ");
        Arrays.sort(splits, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        });
        String[] res = new String[3];
        for (int i = 0; i < 3; i++) {
            res[i] = splits[i];
        }
        Arrays.sort(res);
        for (int i = 2; i >= 0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
