package offer;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode old = pre;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
        }
        pre.next = (l1 != null) ? l1 : l2;
        return old.next;
    }
}
