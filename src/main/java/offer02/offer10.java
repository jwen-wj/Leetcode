package offer02;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/17
 */

public class offer10 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        final int mod = (int) 1e9 + 7;
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (a + b) % mod;
            a = b;
            b = result;
        }
        return result;
    }

    public int numWays(int n) {
        if (n == 1 || n == 0) return 1;
        if (n == 2) return 2;
        final int mod = (int) 1e9 + 7;
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = (a + b) % mod;
            a = b;
            b = result;
        }
        return result;
    }
}
