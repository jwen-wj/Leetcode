package codetop;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class codetop03 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (nums[i] >= queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
