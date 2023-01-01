package mayi;

import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/15
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append('a');
        }
        String s = sb.toString();
        StringBuilder temp = new StringBuilder(s);
        while (true) {
            s = temp.toString();
            temp = new StringBuilder();
            boolean exist = false;
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1) {
                    temp.append(s.charAt(i));
                    break;
                }
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i + 1);
                if (ch1 == ch2) {
                    exist = true;
                    char ch = (char) (ch1 + 1);
                    temp.append(ch);
                    i++;
                } else {
                    temp.append(ch1);
                }
            }
            if (!exist) {
                break;
            }
        }

        System.out.println(temp);
    }
}
