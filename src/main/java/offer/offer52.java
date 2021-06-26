package offer;

import leetcode.ListNode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/10
 */

public class offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode oldA = headA;
        ListNode oldB = headB;
        while (headA != headB) {
            headA = (headA == null ? oldB : headA.next);
            headB = (headB == null ? oldA : headB.next);
        }
        return headA;
    }
}
