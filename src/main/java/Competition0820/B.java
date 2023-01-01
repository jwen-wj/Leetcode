package Competition0820;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/20
 */

public class B {
    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0;
        while (true) {
            StringBuffer sb = deal(s);
            if (s.equals(sb.toString())) {
                break;
            }
            s = sb.toString();
            cnt++;
        }
        return cnt;
    }

    public StringBuffer deal(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                sb.append("10");
                i += 2;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb;
    }
}
