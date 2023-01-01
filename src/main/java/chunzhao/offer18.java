package chunzhao;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/10
 */

public class offer18 {
    public static void main(String[] args) {
        offer18 o = new offer18();
        ListNode root = o.deleteNode(Utils.getListNode(new int[]{1, 2, 3, 4, 4, 4, 5, 4, 4, 6, 4, 7}), 4);
        Utils.printListNode(root);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode hair = new ListNode(-1, head);
        ListNode pre = hair;
        ListNode cur = pre.next;
        while (cur != null) {
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
            if (cur != null) {
                cur = cur.next;
            }
        }

        return hair.next;
    }
}
