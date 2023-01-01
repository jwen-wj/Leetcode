package codetop;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/28
 */

public class codetop29 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fast = new ListNode(-1, head);
        ListNode hair = fast;
        ListNode slow = fast;
        for (int i = 1; i <= right; i++) {
            if (i < left) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        ListNode reverse = reverseSingle(slow.next, fast);
        slow.next = reverse;
        return hair.next;
    }

    public ListNode reverseSingle(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = tail.next;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return tail;
    }
}
