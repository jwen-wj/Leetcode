package codetop;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop12 {
    public boolean hasCycle(ListNode head) {
        boolean cycle = false;
        ListNode flag = new ListNode(-1);
        while (head != null) {
            if (head == flag) {
                cycle = true;
                break;
            }
            ListNode next = head.next;
            head.next = flag;
            head = next;
        }
        return cycle;
    }
}
