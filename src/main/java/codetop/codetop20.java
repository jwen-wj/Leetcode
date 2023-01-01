package codetop;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop20 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (slow != pre) {
                    slow = slow.next;
                    pre = pre.next;
                }
                return pre;
            }

        }
        return null;
    }
}
