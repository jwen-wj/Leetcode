package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/7
 */

public class daily0707 {
    public static void main(String[] args) {
        int[] deliciousness = new int[]{1, 3, 5, 7, 9};
        System.out.println(countPairs(deliciousness));
    }

    public static int countPairs(int[] deliciousness) {
        int mod = (int) 1e9 + 7;
        int n = deliciousness.length;
        if (n < 2) return 0;
        int result = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, deliciousness[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
            for (int sum = 1; sum <= max * 2; sum <<= 1) {
                int target = sum - deliciousness[i + 1];
                result = (result + map.getOrDefault(target, 0)) % mod;
            }
        }
        return result;
    }
}
