package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;

        ListNode pre = new ListNode(-1);
        pre.next = first;


        ListNode[] reverse = reverseSingle(first, fifth);
        ListNode head = reverse[0];
        ListNode tail = reverse[1];

        pre.next = head;
//        tail.next = forth;

        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        // 当前头节点
        ListNode pre = new ListNode(-1, head);
        // 哨兵节点，保持不动
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

    public static ListNode[] reverseSingle(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }
}
