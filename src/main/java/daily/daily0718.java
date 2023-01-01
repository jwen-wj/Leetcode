package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/18
 */

public class daily0718 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                count[ch - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                while (count[i] > 0) {
                    char ch = (char) ('a' + i);
                    sb.append(ch);
                    count[i]--;
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
