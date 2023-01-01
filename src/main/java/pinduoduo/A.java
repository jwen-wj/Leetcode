package pinduoduo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/3
 */

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] str = s.toCharArray();

            Map<Character, Character> mp = new HashMap<>();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                mp.put(ch, ch);
            }

            int idx = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int num = mp.get(str[i]) - 'a';
                if (num <= k) {
                    max = Math.max(max, num);
                    idx++;
                } else {
                    break;
                }
            }

            k -= max;

            for (int i = 0; i < idx; i++) {
                mp.put(str[i], 'a');
            }

            for (int i = 0; i < n; i++) {
                str[i] = mp.get(str[i]);
                int x = str[i] - 'a';
                x = Math.min(k, x);
                k -= x;
                for (int j = 0; j < x; j++) {
                    char prev = (char) (str[i] - j);
                    char now = (char) (str[i] - x);
                    mp.put(prev, now);
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(mp.get(str[i]));
            }
            System.out.println();
        }
    }
}

/**
 * 4
 * 3 2
 * cba
 * 4 5
 * fgde
 * 7 5
 * gndcafb
 * 4 19
 * ekyv
 */
