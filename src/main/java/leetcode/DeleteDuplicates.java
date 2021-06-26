package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = deleteDuplicates(head.next);
        if (head.val == next.val) {
            head.next = next.next;
        }
        return head;
    }
}
