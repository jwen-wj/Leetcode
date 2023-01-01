package shenxinfu;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/1
 */

public class C {
    public ListNode reverseBetween (ListNode head) {
        // write code here
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode slow = hair;
        ListNode fast = hair;
        for (int i = 0; i < 6; i++) {
            if (i < 2) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 1->2->3->-4>->5->6->7
        ListNode next = fast.next;
        ListNode[] reversed = reverseList(slow.next, fast);
        slow.next = reversed[0];
        reversed[1].next = next;
        return hair.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode terminate = tail.next;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != terminate) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
