package offer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/12
 */

public class offer59 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) deque.addLast(nums[i]);
            else {
                while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
            }
        }

        int[] res = new int[nums.length - k + 1];
        int len = 0;
        res[len++] = deque.getFirst();
        for (int l = 0, r = k; r < nums.length; l++, r++) {
            if (nums[l] == deque.getFirst()) deque.removeFirst();
            while (!deque.isEmpty() && nums[r] > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[r]);
            res[len++] = deque.getFirst();
        }
        return res;
    }
}

class MaxQueue {
    LinkedList<Integer> deque1 = new LinkedList<>();
    LinkedList<Integer> deque2 = new LinkedList<>();
    public MaxQueue() {

    }

    public int max_value() {
        if (deque2.isEmpty()) return -1;
        return deque2.getFirst();
    }

    public void push_back(int value) {
        deque1.addLast(value);
        while (!deque2.isEmpty() && value > deque2.getLast()) {
            deque2.removeLast();
        }
        deque2.addLast(value);
    }

    public int pop_front() {
        if (deque1.isEmpty()) return -1;
        int value = deque1.pollFirst();
        if (value == deque2.getFirst()) deque2.removeFirst();
        return value;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */