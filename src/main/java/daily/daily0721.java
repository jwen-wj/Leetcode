package daily;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/21
 */

public class daily0721 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
