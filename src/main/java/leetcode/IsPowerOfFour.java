package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int x = (int)Math.sqrt(n);
        if (x * x != n) {
            return false;
        }
        return (x & (x - 1)) == 0;
    }
}
