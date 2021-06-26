package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/27
 */

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        Long result = 0L;
        int neg = 1;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判断前导空格
            if (c == ' ') {
                continue;
            }
            if (flag > 1) {
                break;
            }
            // 判断负号
            if (c == '-') {
                neg = -1;
                flag++;
                continue;
            }
            if (c == '+') {
                neg = 1;
                flag++;
                continue;
            }
            // 判断数字，进行计算
            if (c >= '0' && c <= '9') {
                result = result * 10L + (c - '0');
                // 判断是否越界
                if (result > Integer.MAX_VALUE && neg == 1) {
                    return Integer.MAX_VALUE;
                } else if (neg == -1 && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return Integer.parseInt(result.toString()) * (neg);
    }
}
