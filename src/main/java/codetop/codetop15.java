package codetop;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop15 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb1 = new StringBuffer(num1);
        StringBuffer sb2 = new StringBuffer(num2);
        sb1.reverse();
        sb2.reverse();
        int len = Math.max(sb1.length(), sb2.length());
        int a, b;
        StringBuffer res = new StringBuffer();
        int pre = 0;
        for (int i = 0; i < len; i++) {
            if (i < sb1.length()) {
                a = sb1.charAt(i) - '0';
            } else {
                a = 0;
            }
            if (i < sb2.length()) {
                b = sb2.charAt(i) - '0';
            } else {
                b = 0;
            }
            int c = a + b + pre;
            pre = c / 10;
            char ch = (char) ((c % 10) + '0');
            res.append(ch);
        }
        if (pre == 1) res.append('1');
        return res.reverse().toString();
    }
}
