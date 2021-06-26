package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/6
 */

public class offer45 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        int len = 0;
        for (int num : nums) {
            str[len++] = String.valueOf(num);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long num1 = Long.parseLong(o1 + o2);
                long num2 = Long.parseLong(o2 + o1);
                if (num1 == num2) return 0;
                return num1 > num2 ? 1 : -1;
            }
        });
        StringBuffer result = new StringBuffer();
        for (String s : str) {
            result.append(s);
        }
        return result.toString();
    }
}
