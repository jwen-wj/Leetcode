package daily;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/11
 */

public class daily0711 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }

        int tot = 0;
        for (int i = n; i >= 0; i--) {
            tot += count[i];
            if (tot >= i) return i;
        }
        return 0;
    }
}
