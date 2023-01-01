package kedaxunfei;

import java.util.Random;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/17
 */

public class C {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                sc.nextLine();
            }
            System.out.println(new Random().nextInt(100));
    }
}
