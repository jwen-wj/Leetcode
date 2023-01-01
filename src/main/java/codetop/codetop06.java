package codetop;

import leetcode.ListNode;
import sun.applet.AppletResourceLoader;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class codetop06 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode pre = new ListNode(-1, head);
        ListNode hair = pre;
        while (pre != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                if (tail.next == null) {
                    return hair.next;
                }
                tail = tail.next;
            }
            head = pre.next;
            ListNode[] reverse = reverseSingle(head, tail);
            pre.next = reverse[0];
            pre = reverse[1];
        }
        return hair.next;
    }

    public ListNode[] reverseSingle(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = tail.next;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
