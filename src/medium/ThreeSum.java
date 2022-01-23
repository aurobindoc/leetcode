package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aurobindo.m on 22/01/22
 * <p>
 * Problem: https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new LinkedList<>();
        Arrays.sort(nums);
        int sum2 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                sum2 = 0 - nums[i];
                for (int l = i + 1, r = nums.length - 1; l < r; ) {
                    if (nums[l] + nums[r] < sum2) {
                        l++;
                    } else if (nums[l] + nums[r] > sum2) {
                        r--;
                    } else {
                        sum.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
