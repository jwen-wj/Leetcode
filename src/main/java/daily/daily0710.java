package daily;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/10
 */

public class daily0710 {
    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public daily0710() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        Integer integer = map.get(key).floorKey(timestamp);
        if (integer == null) return "";
        return map.get(key).get(integer);
    }
}
