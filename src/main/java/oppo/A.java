package oppo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/2
 */

public class A {
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        int result = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            result = result * 10 + digits[i];
        }

        return result;
    }

    public static void main(String[] args) {
        A a = new A();
        int[] digits = new int[]{0, 1, 2, 4, 1, 9};
        System.out.println(a.maxDigit(digits));
    }
}
