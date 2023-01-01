package yuanfudao;

import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/26
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int min = 0;
        while (m-- != 0) {
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            int num = Integer.parseInt(ss[ss.length - 1]);
            min = Math.max(min, num);
        }
        System.out.println(min);
    }
}
