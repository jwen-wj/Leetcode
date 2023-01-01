package chunzhao;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/10
 */

public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k == 0) {
            return null;
        }
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode(-1, head);
        ListNode fast = hair, slow = hair;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
