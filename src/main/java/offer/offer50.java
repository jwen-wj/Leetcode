package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer50 {
    public char firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        Map<Character, Integer> map = new HashMap<>();
        if (len == 0) return ' ';
        for (int i = 0; i < len; i++) {
            char ch = chs[i];
            if (map.containsKey(ch)) {
                map.put(ch, Integer.MAX_VALUE);
            } else {
                map.put(ch, i);
            }
        }
        int min = Integer.MAX_VALUE;
        char ch = '\0';
        for (Character character : map.keySet()) {
            int index = map.get(character);
            if (index < min) {
                min = index;
                ch = character;
            }
        }
        return ch;
    }
}
