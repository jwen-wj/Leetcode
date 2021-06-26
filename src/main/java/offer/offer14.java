package offer;

import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer14 {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
            result %= 1000000007;
        }
        return (int) (n * result % 1000000007);
    }
}
