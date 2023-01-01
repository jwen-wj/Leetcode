package qiuzhao;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jwen
 * @date: 2022/8/18
 */

public class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;
    int size;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    // 取：
    //      存在：拿出元素，放置队头
    //      不存在：返回 -1
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        return -1;
    }

    // 放：
    //      存在：更新值，更新size，放置队头
    //           满：size--，去除队尾，map删除key
    //      不存在：更新值，放置队头
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            size++;
            node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if (size > capacity) {
                Node removed = removeTail();
                map.remove(removed.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }

        public Node() {
        }
    }
}
