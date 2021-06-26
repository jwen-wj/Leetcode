package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/27
 */

public class Convert {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuffer());
        }
        int curRow = 0;
        Boolean goingDown = false;
        for (char ch : s.toCharArray()) {
            rows.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
