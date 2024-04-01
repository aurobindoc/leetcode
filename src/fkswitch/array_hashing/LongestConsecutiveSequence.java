package fkswitch.array_hashing;

import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for(int num: nums)  {
            if(!set.contains(num-1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longestStreak = Math.max(longestStreak, currentLength);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
}