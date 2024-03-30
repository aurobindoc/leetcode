package old.medium;

import utils.ListNode;

/**
 * Created by aurobindo.m on 26/01/22
 * <p>
 * Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode tail = new ListNode();
        tail.next = head;
        while (head != null && head.next != null) {
            tail.next = head.next;
            head.next = tail.next.next;
            tail.next.next = head;
            tail = tail.next.next;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode.printList(new SwapNodesInPairs().swapPairs(head));
    }
}
