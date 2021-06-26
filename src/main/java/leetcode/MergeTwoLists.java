package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode old = new ListNode();
        ListNode move = new ListNode();
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                move = l1;
                l1 = l1.next;
            } else {
                move = l2;
                l2 = l2.next;
            }

        } else if (l1 != null) {
            move = l1;
            l1 = l1.next;
        } else {
            move = l2;
            l2 = l2.next;
        }
        old = move;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    move.next = l1;
                    l1 = l1.next;
                } else {
                    move = l2;
                    l2 = l2.next;
                }

            } else if (l1 != null) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        return old;
    }
}
