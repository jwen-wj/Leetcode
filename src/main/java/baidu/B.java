package baidu;

import java.util.Random;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            String s = sc.nextLine();
            int rm = new Random().nextInt(2);
            if (rm == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
