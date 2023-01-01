package tianyiyun;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/10/6
 */

public class A{
    public int sqrt (int x) {
        // write code here
        long target = x;
        long l = 0;
        long r = x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m * m == target) {
                return (int)m;
            } else if (m * m > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int)r;
    }

    public ArrayList<Integer> timesExceptSelf (ArrayList<Integer> nums) {
        // write code here
        int size = nums.size();
        Integer[] a = new Integer[size];
        for (int i = 0; i < size; i++) {
            a[i] = nums.get(i);
        }
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = 1;
        right[size - 1] = 1;
        for (int i = 1; i < size; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = size - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(left[i] * right[i]);
        }

        return arr;
    }
}
