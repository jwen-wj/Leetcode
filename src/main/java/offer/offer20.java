package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer20 {
    public boolean isNumber(String s) {
        int countE = 0;
        int indexE = 0;
        String dealed = s.trim();
        for (int i = 0; i < dealed.length(); i++) {
            char ch = dealed.charAt(i);
            if (ch != ' ') {
                if (ch == 'e' || ch == 'E') {
                    countE++;
                    indexE = i;
                }
            }
        }
        if (countE == 1) {
            return (isDouble(dealed, 0, indexE - 1) || isInt(dealed, 0, indexE - 1))
                    && isInt(dealed, indexE + 1, dealed.length() - 1);
        } else if (countE == 0) {
            return isDouble(dealed, 0, dealed.length() - 1) || isInt(dealed, 0, dealed.length() - 1);
        } else {
            return false;
        }
    }

    public boolean isInt(String s, int l, int r) {
        if (l > r) {
            return false;
        }
        int len = l - r + 1;
        int countSymbol = 0;
        int indexSymbol = -1;
        int countNumber = 0;
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                countSymbol++;
                if (indexSymbol == -1) {
                    indexSymbol = i;
                }
            } else if (ch >= '0' && ch <= '9') {
                countNumber++;
            }
        }
        if (countSymbol == 0 || (indexSymbol == l && countSymbol == 1)) {
            return (countNumber + countSymbol) == len && countNumber >= 1;
        }
        return false;
    }

    public boolean isDouble(String s, int l, int r) {
        if (l > r) {
            return false;
        }
        int len = r - l + 1;
        int countDot = 0;
        int indexDot = -1;
        int countSymbol = 0;
        int indexSymbol = -1;
        int countNumber = 0;
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                countSymbol++;
                if (indexSymbol == -1) {
                    indexSymbol = i;
                }
            }
            if (ch == '.') {
                countDot++;
                if (indexDot == -1) {
                    indexDot = i;
                }
            }
            if (ch >= '0' && ch <= '9') {
                countNumber++;
            }
        }
        if (countDot + countNumber + countSymbol == len) {
            if (countSymbol == 0 || (indexSymbol == l && countSymbol == 1)) {
                if (countDot == 1 && indexDot > l && indexDot < r) {
                    if (s.charAt(indexDot - 1) >= '0' && s.charAt(indexDot + 1) >= '0' &&
                            s.charAt(indexDot - 1) <= '9' && s.charAt(indexDot + 1) <= '9') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
