package com.example.lib2.offer;

/**  链表反转
 * 链表的题就是注意指针方向转换，利用next调换指针方向
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        ListNode nodea = solution.reverseList(node);
        for (int i =0;i<5;i++){
            System.out.println(nodea.val);
            System.out.println(nodea.next);
            nodea = nodea.next;
        }
    }
}


