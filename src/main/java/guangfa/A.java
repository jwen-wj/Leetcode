package guangfa;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/7
 */

public class A {
    public boolean isPalindromeBit (int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            n >>= 1;
        }
        StringBuilder reversed = new StringBuilder(sb);
        reversed.reverse();
        return reversed.toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.isPalindromeBit(5));
    }
}
