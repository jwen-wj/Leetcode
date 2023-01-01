package shenxinfu;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/1
 */

public class B {
    public static void main(String[] args) {

    }

    int[] conv;
    int cnt = 0;

    public int nucleicAcidTestWay (int n) {
        conv = new int[n];
        dfs(n, 0);
        return cnt;
        // write code here
        // 当前不做
        // xxx0

        // 当天已做
        // xxx1

        // dp[0][j] 第j天不做做核酸的方案 dp[0][j] = dp[1][j - 1]
        // dp[1][j] 第j天做核酸的方案    dp[1][j] = dp[0][j - 1] + dp[1][j - 1]
    }

    public void dfs(int n, int i) {
        if (i == n) {
            cnt++;
            return;
        }

        // 第i天做核酸
        conv[i] = 1;
        dfs(n, i + 1);
        conv[i] = 0;

        // 第i天不做核酸
        if (i > 0 && conv[i - 1] != -1) {
            conv[i] = -1;
            dfs(n, i + 1);
            conv[i] = 0;
        }
    }
}
