package offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2021/7/13
 */

public class LRUCache {

    class DLinkedNode {
        DLinkedNode prev;
        DLinkedNode next;
        int value;
        int key;
        public DLinkedNode(){}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    Map<Integer, DLinkedNode> map;

    int capacity;

    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.prev = tail;
        head.next = tail;
        tail.prev = head;
        tail.next = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addToTail(node);
            if (map.size() > capacity) {
                DLinkedNode removedNode = removeHead();
                map.remove(removedNode.key);
            }
        }
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToTail(DLinkedNode node) {
        removeNode(node);
        addToTail(node);
    }

    public void addToTail(DLinkedNode node) {
        DLinkedNode prev = tail.prev;
        prev.next = node;
        node.next = tail;
        node.prev = prev;
        tail.prev = node;
    }

    public DLinkedNode removeHead() {
        DLinkedNode node = head.next;
        removeNode(node);
        return node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
