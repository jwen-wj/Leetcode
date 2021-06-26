package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer10 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int x = 0;
        int y = 1;
        int z = 0;
        for (int i = 2; i <= n; i++) {
            z = (x + y) % 1000000007;
            x = y;
            y = z;
        }
        return z;
    }
}
