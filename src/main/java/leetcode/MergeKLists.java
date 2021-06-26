package leetcode;

/**
 * @description:
 * @author: jwen
 * @date: 2021/6/1
 */

public class MergeKLists {
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode pre = new ListNode(0);
        ListNode prehead = pre;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            pre.next = min;
            pre = pre.next;
            if (min.next != null) {
                queue.add(min.next);
            }
        }
        return prehead.next;
    }
     */

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeTwoPart(lists, 0, lists.length - 1);
    }

    public ListNode mergeTwoPart(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + (r - l)) >> 1;
        return mergeTwoList(mergeTwoPart(lists, l, mid), mergeTwoPart(lists, mid + 1, r));
    }

    public ListNode mergeTwoList(ListNode x, ListNode y) {
        ListNode a = x;
        ListNode b = y;
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode pre = new ListNode();
        ListNode prehead = pre;
        while (a.next != null && b.next != null) {
            if (a.val < b.val) {
                pre.next = a;
                a = a.next;
            } else {
                pre.next = b;
                b = b.next;
            }
            pre = pre.next;
        }
        pre.next = (a.next == null) ? b : a;
        return prehead.next;
    }
}
