package fkswitch.array_hashing;

import utils.IntArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(target - nums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        int[] nums = { 2, 4, 11, 3 };
        int target = 6;

        IntArrayUtils.printList(twoSum.twoSum(nums, target));
    }
}
