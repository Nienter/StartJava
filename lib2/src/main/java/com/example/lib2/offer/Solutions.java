package com.example.lib2.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表复制
 * 出列next指向下一个node，还有一个random指针指向随意一个node
 */
public class Solutions {
    public Node copyRandomList(Node head) {
        Map<Node, Node> m = new HashMap<>();
        Node p = head;
        while (head != null) {
            Node t = new Node(head.val);
            m.put(head, t);
            head = head.next;
        }
        head = p;
        while (head != null) {
            Node n = head.next;
            Node r = head.random;
            m.get(head).next = m.get(n);
            m.get(head).random = m.get(r);
            head = head.next;
        }
        return m.get(p);

    }

    public static void main(String[] args) {
        Node node = new Node(7);
    }
}
