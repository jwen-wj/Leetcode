package offer;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
