package medium;

import utils.ListNode;

/**
 * Created by aurobindo.m on 25/01/22
 * <p>
 * Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode v1 = new ListNode();
        v1.next = head;
        ListNode v2 = new ListNode();
        v2.next = head;
        ListNode res = v1;

        while (n >= 0) {
            v2 = v2.next;
            n--;
        }
        while (v2 != null) {
            v1 = v1.next;
            v2 = v2.next;
        }
        v1.next = v1.next.next;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        ListNode.printList(new RemoveNthNode().removeNthFromEnd(head, n));
    }

}
