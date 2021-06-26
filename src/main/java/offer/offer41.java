package offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/5
 */
public class offer41 {

}

class MedianFinder {
    Queue<Integer> minQueue;
    Queue<Integer> maxQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        maxQueue = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (maxQueue.size() == minQueue.size()) {
            maxQueue.offer(num);
        } else {
            minQueue.offer(num);
        }
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            while (maxQueue.peek() < minQueue.peek()) {
                int a = minQueue.poll();
                int b = maxQueue.poll();
                maxQueue.offer(a);
                minQueue.offer(b);
            }
        }
    }

    public double findMedian() {
        double result;
        if (maxQueue.size() == minQueue.size()) {
            result = (double) (maxQueue.peek() + minQueue.peek()) / 2;
        } else {
            result = maxQueue.peek();
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */