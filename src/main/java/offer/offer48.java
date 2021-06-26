package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/9
 */

public class offer48 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        else if (len == 1) return 1;
        int start = 0;
        int maxlen = -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        map.put(chs[0], 0);
        for (int end = 1; end < len; end++) {
            char ch = chs[end];
            if (map.containsKey(ch) && map.get(ch) >= start) {
                maxlen = Math.max(maxlen, end - start);
                start = map.get(ch) + 1;
            } else {
                maxlen = Math.max(maxlen, end - start + 1);
            }
            map.put(ch, end);
        }
        return maxlen;
    }
}
