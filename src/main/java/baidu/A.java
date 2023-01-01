package baidu;

import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/13
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> sets = new HashSet<>();
        sets.add('a');
        sets.add('e');
        sets.add('i');
        sets.add('o');
        sets.add('u');
        if (s.length() < 5) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int j = 0; j <= s.length() - 5; j++) {
            int[] num = new int[26];
            for (int i = 0; i < 5; i++) {
                char ch = s.charAt(j + i);
                num[ch - 'a']++;
            }
            boolean equ = false;
            for (int i = 0; i < 26; i++) {
                if (num[i] > 1) {
                    equ = true;
                    break;
                }
            }
            if (equ) {
                continue;
            }
            char b = s.charAt(j);
            char a = s.charAt(j + 1);
            char i = s.charAt(j + 2);
            char d = s.charAt(j + 3);
            char u = s.charAt(j + 4);
            if (!sets.contains(b) && !sets.contains(d) && sets.contains(a) && sets.contains(i) && sets.contains(u)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
