package offer02;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/19
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
