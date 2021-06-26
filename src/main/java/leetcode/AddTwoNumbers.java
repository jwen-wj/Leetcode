package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/22
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int push = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + push;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val + push;
                l1 = l1.next;
            } else {
                val = l2.val + push;
                l2 = l2.next;
            }

            if (val >= 10) {
                val -= 10;
                push = 1;
            } else {
                push = 0;
            }

            if (head == null) {
                head = tail = new ListNode(val);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }

        if (push == 1) {
            tail.next = new ListNode(1);
        }

        return head;
    }
}
