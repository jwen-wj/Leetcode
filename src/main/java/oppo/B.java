package oppo;

import leetcode.ListNode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: jwen
 * @date: 2022/9/2
 */

public class B {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        int N = 100005;
        ListNode[] nodes = new ListNode[N];
        int len = 0;
        while (node1 != null) {
            nodes[len++] = new ListNode(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            nodes[len++] = new ListNode(node2.val);
            node2 = node2.next;
        }
        ListNode[] now = new ListNode[len];
        for (int i = 0; i < len; i++) {
            now[i] = nodes[i];
        }
        Arrays.sort(now, Comparator.comparingInt(o -> o.val));
        ListNode hair = new ListNode(-1);
        ListNode cur = hair;
        for (int i = 0; i < len; i++) {
            cur.next = now[i];
            cur = cur.next;
        }

        return hair.next;
    }

    public static void main(String[] args) {
        B b = new B();
        ListNode node1 = new ListNode(3, new ListNode(4, new ListNode(1)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(2)));
        ListNode root = b.combineTwoDisorderNodeToOrder(node1, node2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
