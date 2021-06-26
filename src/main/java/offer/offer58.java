package offer;

import java.util.Stack;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer58 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        s = s.trim();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            StringBuffer sb = new StringBuffer();
            boolean valid = false;
            while (i < chs.length && chs[i] != ' ') {
                sb.append(chs[i]);
                i++;
                valid = true;
            }
            if (valid) stack.add(sb.toString());
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }
        String result = sb.toString().trim();
        return result;
    }

    public String reverseLeftWords(String s, int n) {
        StringBuffer head = new StringBuffer();
        StringBuffer tail = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i < n) tail.append(s.charAt(i));
            else head.append(s.charAt(i));
        }
        return head.toString() + tail.toString();
    }
}
