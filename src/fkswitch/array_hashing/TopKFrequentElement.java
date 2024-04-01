package fkswitch.array_hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        // Sort the map based on values
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public int[] topKFrequentHeap(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // Create a min heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int i : map.keySet()) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        int[] nums = { 1, 2, 2, 3, 3, 3, 3, 3 };
        int k = 2;
        System.out.println(topKFrequentElement.topKFrequent(nums, k));
        System.out.println(topKFrequentElement.topKFrequentHeap(nums, k));
    }
}

