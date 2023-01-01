package yongyou;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/9
 */

public class A {
    public static void main(String[] args) {

    }

    public long calculateTotal (int count) {
        // write code here
        long[] dp = new long[count + 1];
        if (count <= 2) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= count; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[count];
    }
}
