package gaotu;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/29
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() <= 1) {
            System.out.println(s);
            return;
        }
        int[] num = new int[10];
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int tmp = s.charAt(i) - '0';
            if (tmp == 0 && !flag) {
                continue;
            }
            if (num[tmp] == 0) {
                System.out.print(tmp);
            }
            flag = true;
            num[tmp]++;
        }
        System.out.println();
    }
}
