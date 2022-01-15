package medium;

/**
 * Created by aurobindo.m on 15/01/22
 * <p>
 * Problem: https://leetcode.com/problems/add-two-numbers/
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArray(int[] nums) {
        ListNode head = new ListNode();
        ListNode tail = head;

        for (int i = 0; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return head.next;
    }

    public static void printList(ListNode l) {
        System.out.print("[");
        while (l != null && l.next != null) {
            System.out.print(l.val + ", ");
            l = l.next;
        }
        System.out.println(l.val + "]");
    }
}

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
