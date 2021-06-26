package offer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/5
 */

public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (k == length) {
            return arr;
        }
        int[] result = new int[k];
        int len = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < length - k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = length - k; i < length; i++) {
            if (arr[i] > queue.peek()) {
                result[len++] = queue.poll();
                queue.offer(arr[i]);
            } else {
                result[len++] = arr[i];
            }
        }
        return result;
    }
}
