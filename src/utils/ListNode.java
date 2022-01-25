package utils;

/**
 * Created by aurobindo.m on 25/01/22
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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