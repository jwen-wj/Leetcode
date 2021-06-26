package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(3,
                                            new ListNode(4, null))));
        ListNode pre = swapPairs(head);
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
