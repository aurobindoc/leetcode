package old.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aurobindo.m on 23/01/22
 * <p>
 * Problem: https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                sum2 = target - nums[i];
                for (int l = i + 1, r = nums.length - 1; l < r; ) {
                    if (minDiff > Math.abs(nums[i] + nums[l] + nums[r] - target)) {
                        minDiff = Math.abs(nums[i] + nums[l] + nums[r] - target);
                        minSum = nums[i] + nums[l] + nums[r];
                    }
                    if (nums[l] + nums[r] < sum2) {
                        l++;
                    } else if (nums[l] + nums[r] > sum2) {
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
