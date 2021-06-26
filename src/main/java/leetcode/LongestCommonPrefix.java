package leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuffer string = new StringBuffer("");
        for (int i = 0; i < strs[0].length(); i++) {
            boolean equal = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                    equal = false;
                    break;
                }
            }
            if (!equal) {
                return string.toString();
            }
            string.append(strs[0].charAt(i));
        }
        return string.toString();
    }
}
