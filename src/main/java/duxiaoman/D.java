package duxiaoman;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/31
 */

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s1_split = s1.split(" ");
        String[] s2_split = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s2_split.length; i++) {
            map.put(s2_split[i], i);
        }
        boolean hasLeft = false;
        int len = 0;
        String[] result = new String[s1_split.length];
        for (int i = 0; i < s1_split.length; i++) {
            if (Objects.equals(s1_split[i], "\"")) {
                if (!hasLeft) {
                    hasLeft = true;
                } else {
                    hasLeft = false;
                }
            }
            if (hasLeft || Objects.equals(s1_split[i], "\"")) {
                result[i] = s1_split[i];
            } else {
                if (map.containsKey(s1_split[i])) {
                    result[i] = String.valueOf(map.get(s1_split[i]));
                } else {
                    result[i] = s1_split[i];
                }

            }
        }

        for (int i = 0; i < s1_split.length; i++) {
            if (i == 0) {
                System.out.print(result[i]);
            } else {
                System.out.print(" " + result[i]);
            }
        }
        System.out.println();
    }
}
