package pinduoduo;

import java.util.*;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/15
 */

public class mian1 {
    public static void main(String[] args) {

    }

    public static int[] profit(int[] nums1, int[] nums2) {
        // 2,7,11,15
        // 1,10,4,11
        // 2,11,7,15
        int[] sorted1 = nums1.clone();
        int[] sorted2 = nums2.clone();
        Arrays.sort(sorted1);
        Arrays.sort(sorted2);
        Map<Integer, Queue<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], new LinkedList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            if (num > nums2[j]) {
                map.get(nums2[j]).add(num);
                j++;
            } else {
                queue.add(num);
            }
        }

        int[] result = new int[nums1.length];
        int len = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                result[len++] = map.get(nums2[i]).poll();
            } else {
                result[len++] = queue.poll();
            }
        }

        return result;
    }
}
