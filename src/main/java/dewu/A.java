package dewu;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/30
 */

public class A {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode hair = new ListNode(-1);
        ListNode cur = hair;
        int add = 0;
        while (head1 != null && head2 != null) {
            int a = head1.val;
            int b = head2.val;
            int c = (a + b + add) % 10;
            add = (a + b + add) / 10;
            cur.next = new ListNode(c);
            cur = cur.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int c = (head1.val + add) % 10;
            cur.next = new ListNode(c);
            add = (head1.val + add) / 10;
            cur = cur.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            int c = (head2.val + add) % 10;
            cur.next = new ListNode(c);
            add = (head2.val + add) / 10;
            cur = cur.next;
            head2 = head2.next;
        }

        if (add != 0) {
            cur.next = new ListNode(add);
        }

        return reverseList(hair.next);
    }

    public ListNode reverseList(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
