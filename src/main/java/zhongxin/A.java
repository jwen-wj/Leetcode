package zhongxin;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/5
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] s = a.split(" ");
        int[] nums = new int[s.length];
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = Integer.parseInt(s[i]);
            int num2 = Integer.parseInt(s[i + 1]);
            if (num2 >= num1) {
                result += num2 - num1;
            }
        }
        System.out.println(result);
    }
}
