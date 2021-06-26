package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/5
 */

public class offer38 {
    Set<String> combinations = new HashSet<>();
    StringBuffer combination = new StringBuffer();
    int count = 0;

    public String[] permutation(String s) {
        dfs(s.toCharArray(), 0);
        String[] result = new String[combinations.size()];
        int len = 0;
        for (String str : combinations) {
            result[len++] = str;
        }
        return result;
    }

    public void dfs(char[] s, int k) {
        if (k == s.length) {
            combinations.add(String.valueOf(combination));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (ch != '\0') {
                combination.append(ch);
                s[i] = '\0';
                dfs(s, k + 1);
                s[i] = ch;
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
