package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer60 {
    public static void main(String[] args) {
        double[] dp = dicesProbability(2);
        for (double num : dp) {
            System.out.print(num + " ");
        }
    }
    public static double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
