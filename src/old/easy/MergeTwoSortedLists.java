package old.easy;

import utils.ListNode;

/**
 * Created by aurobindo.m on 25/01/22
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode result = new ListNode();
        result.next = head;
        while (list1 != null && list2 != null) {
            head.next = new ListNode();
            head = head.next;
            if (list1.val <= list2.val) {
                head.val = list1.val;
                list1 = list1.next;
            } else {
                head.val = list2.val;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            list1 = list2;
        }
        while (list1 != null) {
            head.next = new ListNode();
            head = head.next;
            head.val = list1.val;
            list1 = list1.next;
        }
        return result.next.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[]{1, 2, 4});
        ListNode l2 = ListNode.fromArray(new int[]{1, 3, 4});
        ListNode.printList(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
