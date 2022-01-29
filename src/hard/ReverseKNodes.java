package hard;

import utils.ListNode;

/**
 * Created by aurobindo.m on 26/01/22
 * <p>
 * Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKNodes {
    private ListNode reverse(ListNode head) {
        ListNode curr = head, temp = null, prev = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode node = ans, prev = null, temp = null;
        int count;
        while (head != null) {
            count = 0;
            prev = head;
            while (head != null && count < k-1) {
                head = head.next;
                count++;
            }
            if (count == k-1 && head != null) {
                temp = head.next;
                head.next = null;
                head = temp;
                node.next = reverse(prev);
                node = prev;
            } else {
                node.next = prev;
                node = prev;
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode.printList(new ReverseKNodes().reverseKGroup(head, 3));
    }
}
