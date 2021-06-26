package daily;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/19
 */

public class daily0619 {
    List<String> str;
    int max = -1;
    public int maxLength(List<String> arr) {
        str = arr;
        dfs(0, new HashSet<>());
        return max;
    }

    public void dfs(int pos, Set<Character> exists) {
        if (pos == str.size()) {
            max = Math.max(max, exists.size());
            return;
        }
        Set<Character> temp = new HashSet<>();
        String s = str.get(pos);
        boolean exist = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!temp.isEmpty()) {
                if (temp.contains(ch)) {
                    exist = true;
                    break;
                }
            }
            temp.add(ch);
        }
        for (Character character : temp) {
            if (exists.contains(character)) exist = true;
        }
        dfs(pos + 1, exists);
        if (!exist) {
            Set<Character> newSet = new HashSet<>();
            newSet.addAll(exists);
            newSet.addAll(temp);
            dfs(pos + 1, newSet);
        }
    }
}
