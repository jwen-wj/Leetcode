package dewu;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class B {
    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(solve(IP));
    }

    public static String solve (String IP) {
        // write code here
        if (IP.contains(".")) {
            String[] IPV4s = IP.split("\\.", -1);
            if (IPV4s.length == 4) {
                boolean flag = true;
                for (int i = 0; i < IPV4s.length; i++) {
                    flag &= isIPV4(IPV4s[i]);
                }
                if (flag) {
                    return "IPv4";
                }
            }
        }

        if (IP.contains(":")) {
            String[] IPV6s = IP.split(":", -1);
            if (IPV6s.length == 8) {
                boolean flag = true;
                for (int i = 0; i < IPV6s.length; i++) {
                    flag &= isIPV6(IPV6s[i]);
                }
                if (flag) {
                    return "IPv6";
                }
            }
        }

        return "Neither";
    }

    public static boolean isIPV4(String s) {
        if (s.length() < 1) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        int num = Integer.parseInt(s);
        return 0 <= num && num <= 255;
    }

    public static boolean isIPV6(String s) {
        if (s.length() < 1) {
            return false;
        }
        if (s.length() > 4) {
            return false;
        }

        // 判断数字是否合规
        boolean all_zero = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch < 'a' || ch > 'e') {
                    return false;
                }
                all_zero = false;
            } else if (ch != '0') {
                all_zero = false;
            }
        }

        if (all_zero && s.length() > 1) {
            return false;
        }

        return true;
    }
}
