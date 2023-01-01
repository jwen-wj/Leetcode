package xinye;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/22
 */

public class A {
    Map<String, Integer> map = new HashMap<>();

    public int dateArraysSum (String[] dates) {
        // write code here
        map.put("Jan", 0);
        map.put("Feb", 31);
        map.put("Mar", 31 + 28);
        map.put("Apr", 31 + 28 + 31);
        map.put("May", 31 + 28 + 31 + 30);
        map.put("Jun", 31 + 28 + 31 + 30 + 31);
        map.put("Jul", 31 + 28 + 31 + 30 + 31 + 30);
        map.put("Aug", 31 + 28 + 31 + 30 + 31 + 30 + 31);
        map.put("Sep", 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31);
        map.put("Oct", 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30);
        map.put("Nov", 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31);
        map.put("Dec", 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30);

        Set<String> set = new HashSet<>(Arrays.asList(dates));

        int cnt = 0;
        for (String date : set) {
            cnt += cal(date);
        }

        return cnt;
    }

    public int cal(String date) {
        String[] splits = date.split(" ");
        int d = 0;
        for (int i = 0; i < splits[0].length(); i++) {
            if (Character.isDigit(splits[0].charAt(i))) {
                d = d * 10 + splits[0].charAt(i) - '0';
            } else {
                break;
            }
        }

        int m = map.get(splits[1]);

        int y = isLoop(splits[2]) ? 1 : 0;

        int res = d + m;

        if (!splits[1].equals("Jan") && !splits[1].equals("Feb")) {
            res += y;
        }

        return res;
    }

    public boolean isLoop(String year) {
        int y = Integer.parseInt(year);
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}
