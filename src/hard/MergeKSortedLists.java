package hard;

import easy.MergeTwoSortedLists;
import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aurobindo.m on 26/01/22
 *
 * Problem: https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> newLists1 = new ArrayList<>();
        Collections.addAll(newLists1, lists);
        ArrayList<ListNode> newLists2;
        if(newLists1.size() == 0) return null;
        while (newLists1.size() != 1) {
            newLists2 = new ArrayList<>();
            int i = 0;
            while (i + 1 < newLists1.size()) {
                newLists2.add(new MergeTwoSortedLists().mergeTwoLists(newLists1.get(i), newLists1.get(i + 1)));
                i += 2;
            }
            if (i < newLists1.size()) newLists2.add(newLists1.get(i));
            newLists1 = newLists2;
        }
        return newLists1.get(0);
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                ListNode.fromArray(new int[]{1, 4, 5}),
                ListNode.fromArray(new int[]{1, 3, 4}),
                ListNode.fromArray(new int[]{2, 6})
        };
        ListNode[] lists1 = new ListNode[]{
        };

        ListNode.printList(new MergeKSortedLists().mergeKLists(lists1));
    }
}
