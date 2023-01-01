package gaotu;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/29
 */

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(" ");
        String s1 = splits[0];
        String s2 = splits[1];
        // 123
        // 456

        // 321 6 -> 837
        // 321 5 -> 516

        String[] strs = new String[s2.length()];
        int zero = 0;
        for (int i = s2.length() - 1; i >= 0; i--) {
            strs[i] = multiple(s1, s2.charAt(i));
            StringBuilder before = new StringBuilder(strs[i]);
            before.reverse();
            for (int j = 0; j < zero; j++) {
                before.append('0');
            }
            before.reverse();
            strs[i] = before.toString();
            zero++;
        }
        String result = "0";
        for (int i = 0; i < s2.length(); i++) {
            result = add(strs[i], result);
        }

        StringBuilder sb = new StringBuilder(result);
        boolean pre_zero = false;
        boolean souted = false;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0' && !pre_zero) {
                continue;
            }
            pre_zero = true;
            souted = true;
            System.out.print(sb.charAt(i));
        }
        if (!souted) {
            System.out.println("0");
        }
        System.out.println();
    }

    public static String add(String s1, String s2) {
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            int c  = (a + b + add) % 10;
            add = (a + b + add) / 10;
            sb.append(c);
        }
        if (s1.length() < s2.length()) {
            for (int i = s1.length(); i < s2.length(); i++) {
                int a = s2.charAt(i) - '0';
                int b = (a + add) % 10;
                add = (a + add) / 10;
                sb.append(b);
            }
        } else {
            for (int i = s2.length(); i < s1.length(); i++) {
                int a = s1.charAt(i) - '0';
                int b = (a + add) % 10;
                add = (a + add) / 10;
                sb.append(b);
            }
        }
        if (add != 0) {
            sb.append(add);
        }

        return sb.toString();
    }

    public static String multiple(String s, char ch) {
        StringBuilder before = new StringBuilder(s);
        s = before.reverse().toString();
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            int b = ch - '0';
            int c = (a * b + add) % 10;
            add = (a * b + add) / 10;
            sb.append(c);
        }
        if (add != 0) {
            sb.append(add);
        }

        return sb.toString();
    }
}
