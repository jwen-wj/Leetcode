package leetcode;/**
 * @description:
 * @author: jwen
 * @date: 2022/9/14
 */

public class treeToDoublyList {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        } else {
            head = root;
        }
        pre = root;
        dfs(root.right);
    }
}

//public class Singleton {
//    private volatile static Singleton singleton;
//    private Singleton(){}
//    public static Singleton getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}