package daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/22
 */

public class daily0722 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node old = head;
        Node old2 = head;
        Node create = new Node(-1);
        Node pre = create;
        while (old != null) {
            create.next = new Node(old.val);
            oldToNew.put(old, create.next);
            create = create.next;
            old = old.next;
        }
        while (old2 != null) {
            Node now = oldToNew.get(old2);
            Node random = oldToNew.get(old2.random);
            now.random = random;
            old2 = old2.next;
        }
        return pre.next;
    }
}
