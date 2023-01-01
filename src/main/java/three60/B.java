package three60;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/27
 */

/**
 * 3 3 3
 * i you he
 * am is are
 * yours his hers
 * 5
 * i am yours
 * you is his
 * he are hers yours
 * i am am yours
 * is his
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nz = sc.nextInt();
        int nw = sc.nextInt();
        int nb = sc.nextInt();
        sc.nextLine();
        String zhu = sc.nextLine();
        String wei = sc.nextLine();
        String bin = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        String[] zhus = zhu.split(" ");
        String[] weis = wei.split(" ");
        String[] bins = bin.split(" ");
        Set<String> zhuset = new HashSet<>(Arrays.asList(zhus));
        Set<String> weiset = new HashSet<>(Arrays.asList(weis));
        Set<String> binset = new HashSet<>(Arrays.asList(bins));
        for (int i = 0; i < n; i++) {
            String content = sc.nextLine();
            if (valid(zhuset, weiset, binset, content)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean valid(Set<String> zhus, Set<String> weis, Set<String> bins, String content) {
        String[] words = content.split(" ");
        int split = -1;
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (weis.contains(words[i])) {
                cnt++;
                split = i;
            }
        }
        if (cnt != 1 || split == 0) {
            return false;
        }

        for (int i = 0; i < split; i++) {
            if (bins.contains(words[i])) {
                return false;
            }
        }

        for (int i = split + 1; i < words.length; i++) {
            if (zhus.contains(words[i])) {
                return false;
            }
        }

        return true;
    }
}
