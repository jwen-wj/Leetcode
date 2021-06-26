package offer;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/3
 */

public class offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
