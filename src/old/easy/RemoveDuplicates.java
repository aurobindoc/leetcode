package old.easy;

/**
 * Created by aurobindo.m on 30/01/22
 * <p>
 * Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int val = nums[0];
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[pointer++] = nums[i];
                val = nums[i];
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5};
        int nonDuplicateLength = new RemoveDuplicates().removeDuplicates(nums);
        System.out.print("[ ");
        for (int i = 0; i < nonDuplicateLength - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.print(nums[nonDuplicateLength - 1] + " ]");
    }

}
