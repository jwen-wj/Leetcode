package offer;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode old = new ListNode();
        old.next = head;
        ListNode pre = old;
        while (pre != null && pre.next != null) {
            ListNode next = pre.next;
            if (next.val == val) {
                pre.next = next.next;
            }
            pre = pre.next;
        }
        return old.next;
    }
}
