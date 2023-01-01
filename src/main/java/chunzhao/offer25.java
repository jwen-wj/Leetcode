package chunzhao;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/10
 */

public class offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        ListNode hair = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return hair.next;
    }
}
