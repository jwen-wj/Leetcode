package meidi;

import java.util.Arrays;
import java.util.Comparator;
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
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            xy[i][1] = sc.nextInt();
        }
        Arrays.sort(xy, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        if (n < 2) {
            System.out.println(0.0000);
            return;
        }

        double result = Double.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double x1 = xy[i][0];
                double y1 = xy[i][1];
                double x2 = xy[j][0];
                double y2 = xy[j][1];

                double temp = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                result = Math.min(result, temp);
            }
        }
//        for (int i = 0; i < n - 1; i++) {
//            double x1 = xy[i][0];
//            double y1 = xy[i][1];
//            double x2 = xy[i + 1][0];
//            double y2 = xy[i + 1][1];
//
//            double temp = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//            result = Math.min(result, temp);
//        }

        System.out.printf("%.4f\n", result);
    }
}
