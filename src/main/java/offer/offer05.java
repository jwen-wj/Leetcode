package offer;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/2
 */

public class offer05 {
    public String replaceSpace(String s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
