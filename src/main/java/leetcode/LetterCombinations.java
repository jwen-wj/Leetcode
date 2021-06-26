package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(map, combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    public void dfs(Map<Character, String> map, List<String> combinations, String digits, int l, StringBuffer stringBuffer) {
        if (l == digits.length()) {
            combinations.add(stringBuffer.toString());
            return;
        }
        String str = map.get(digits.charAt(l));
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i));
            dfs(map, combinations, digits, l++, stringBuffer);
            stringBuffer.deleteCharAt(l - 1);
        }
    }
}
