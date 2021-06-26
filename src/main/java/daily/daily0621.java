package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/21
 */

public class daily0621 {
    int[] hours = new int[4];
    int[] minutes = new int[6];
    int turnedOn;
    List<String> combinations = new ArrayList<>();
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int hour = i >> 6;
            int minute = i & 63;
            if (hour < 12 && minute < 60 && Integer.bitCount(i) == turnedOn) {
                res.add(hour + ":" + (minute <= 9 ? "0" : "") + minute);
            }
        }
        return res;
    }

    public void dfs(int countHour, int countMin, int hourPos, int minPos) {
        if (countHour + countMin == turnedOn) {
            int hour = 0, minute = 0;
            for (int bit : hours) {
                hour = hour * 2 + bit;
            }
            for (int bit : minutes) {
                minute = minute * 2 + bit;
            }
            if (hour >= 0 && hour <= 11 && minute >= 0 && minute <= 59) {
                StringBuffer result = new StringBuffer();
                result.append(hour);
                result.append(':');
                if (minute <= 9) result.append('0');
                result.append(minute);
                if (!combinations.contains(result.toString())) combinations.add(result.toString());
            }
            return;
        }

        if (countHour + countMin < turnedOn) {
            if (minPos < 6) {
                minutes[minPos] = 1;
                dfs(countHour, countMin + 1, hourPos, minPos + 1);
                minutes[minPos] = 0;
                dfs(countHour, countMin, hourPos, minPos + 1);
            }
            if (hourPos < 4) {
                hours[hourPos] = 1;
                dfs(countHour + 1, countMin, hourPos + 1, minPos);
                hours[hourPos] = 0;
                dfs(countHour, countMin, hourPos + 1, minPos);
            }
        }
    }
}
