package meidi;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        double min = 0.0;
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        double result = 0.0;
        while (max - min > 0.000001) {
            double mid = min + (max - min) / 2.0;
            if (valid(a, mid, k)) {
                result = Math.max(result, mid);
                min = mid;
            } else {
                max = mid;
            }
        }
        System.out.printf("%.2f\n", result);
    }

    public static boolean valid(double[] a, double x, int k) {
        int cnt = 0;
        for (double v : a) {
            double num = v;
            while (num - x > 0.000001) {
                num -= x;
                cnt++;
            }
        }
        return cnt >= k;
    }

}
