package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/27
 */

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(0));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        Integer num = x;
        String str = num.toString();
        StringBuffer stringBuffer = new StringBuffer();
        int end = 0;
        char neg = '-';
        if (str.charAt(0) == neg) {
            stringBuffer.append(neg);
            end = 1;
        }
        for (int i = str.length() - 1; i >= end; i--) {
            stringBuffer.append(str.charAt(i));
        }
        try {
            int result = Integer.parseInt(stringBuffer.toString());
            return result;
        } catch (Exception e) {
            return 0;
        }
    }
}
