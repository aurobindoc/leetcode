package old.medium;

import utils.ListNode;

/**
 * Created by aurobindo.m on 15/01/22
 * <p>
 * Problem: https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        ListNode tail = node;

        int rem = 0;
        int res = 0;
        while (l1 != null && l2 != null) {
            res = rem + l1.val + l2.val;
            tail.next = new ListNode(res % 10);
            rem = res / 10;
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }
        while (l1 != null) {
            res = rem + l1.val;
            tail.next = new ListNode(res % 10);
            rem = res / 10;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null) {
            res = rem + l2.val;
            tail.next = new ListNode(res % 10);
            rem = res / 10;
            l2 = l2.next;
            tail = tail.next;
        }
        if (rem > 0) {
            tail.next = new ListNode(rem);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[]{2, 4, 3});
        ListNode l2 = ListNode.fromArray(new int[]{5, 6, 4});
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode.printList(result);
    }
}
