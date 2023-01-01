package chunzhao;

import leetcode.ListNode;

import java.util.List;

/**
 * @description:
 * @author: jwen
 * @date: 2022/12/10
 */

public class Utils {

    public static ListNode getListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode hair = new ListNode();
        ListNode cur = hair;

        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        return hair.next;
    }

    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.printf("%d -> ", root.val);
            root = root.next;
        }
        System.out.println("null");
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
