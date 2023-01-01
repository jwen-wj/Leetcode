package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/5
 */

public class daily0703 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int value = map.getOrDefault(ch, 0);
            map.put(ch, value + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.reverse().toString();
    }
}
