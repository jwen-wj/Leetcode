package leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(123));
    }

    public static String intToRoman(int num) {
        StringBuffer string = new StringBuffer();
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        while (num > 0) {
            for (Integer integer : map.keySet()) {
                if (num >= integer) {
                    string.append(map.get(integer));
                    num -= integer;
                    break;
                }
            }
        }
        return string.toString();
    }

    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;

        for (int i = 0; i < len; i++) {

        }

        return result;
    }
}
