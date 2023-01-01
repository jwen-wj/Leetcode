package codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class codetop02 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int start = 0, ans = 0;
        for (int end = 0; end < array.length; end++) {
            char ch = array[end];
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(ch, end);
        }
        return ans;
    }
}
