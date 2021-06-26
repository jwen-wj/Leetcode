package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int z = x;
        while (x > 0) {
            y = x % 10 + y * 10;
            x /= 10;
        }
        return z == y;
    }
}
