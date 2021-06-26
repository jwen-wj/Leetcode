package offer;

import java.util.Arrays;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        if (len == 1) return new int[]{0};
        int[] pre = new int[len];
        int[] tail = new int[len];
        pre[0] = a[0];
        tail[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * a[i];
        }
        for (int i = len - 2; i > 0; i--) {
            tail[i] = tail[i + 1] * a[i];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) result[i] = tail[i + 1];
            else if (i == len - 1) result[i] = pre[i - 1];
            else result[i] = pre[i - 1] * tail[i + 1];
        }
        return result;
    }
}
