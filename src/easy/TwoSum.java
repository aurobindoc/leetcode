package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by aurobindo.m on 15/01/22
 *
 * Problem: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = (Integer) (target - nums[i]);
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] solution = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(solution));
    }
}
