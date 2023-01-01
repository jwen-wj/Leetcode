package chunzhao;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/8
 */

public class offer14 {
    final int mod = (int) 1e9 + 7;

    public long cal(int x, int a) {
        long res = 1;
        while (a > 0) {
            if ((a & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            a >>= 1;
        }

        return res % mod;
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3 - 1;
        long ans = cal(3, a);
        if (n % 3 == 0) {
            return (int)(ans * 3 % mod);
        } else if (n % 3 == 1) {
            return (int)(ans * 4 % mod);
        }
        return (int)(ans * 6 % mod);
    }
}
