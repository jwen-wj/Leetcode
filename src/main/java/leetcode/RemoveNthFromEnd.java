package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/5/31
 */

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode old = head;
        ListNode first = head;
        ListNode second = new ListNode(-1);
        second.next = head;
        while (n-- > 0) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return old;
    }
}
