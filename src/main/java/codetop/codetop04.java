package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/20
 */

public class codetop04 {
    class Node {
        int key, value;
        Node prev, next;

        Node(){}
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    public codetop04(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            moveToTail(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        Node node = new Node(key, value);
        moveToTail(node);
        map.put(key, node);
        if (map.size() > capacity) {
            Node removed = removeHead();
            map.remove(removed.key);
        }
    }

    public void moveToTail(Node node) {
        Node prev = tail.prev;
        node.prev = prev;
        node.next = tail;
        prev.next = node;
        tail.prev = node;
    }

    public Node removeHead() {
        Node next = head.next;
        head.next = next.next;
        next.next.prev = head;
        return next;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
