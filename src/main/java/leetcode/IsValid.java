package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class IsValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        boolean valid = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.empty()) {
                    return false;
                } else {
                    boolean flag = stack.peek().equals(map.get(ch));
                    if (flag) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                        break;
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        if (stack.empty()) {
            valid = true;
        }
        return valid;
    }
}
