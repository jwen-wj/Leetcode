package codetop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop19 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!map.containsKey(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) return false;
                stack.pop();
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
