package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer62 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
