package guanglianda;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] rule = new int[m][3];
        for (int i = 0; i < m; i++) {
            rule[i][0] = sc.nextInt();
            rule[i][1] = sc.nextInt();
            rule[i][2] = sc.nextInt();
            sc.nextLine();
        }

        System.out.println(n);
    }
}
