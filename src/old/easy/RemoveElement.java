package old.easy;

/**
 * Created by aurobindo.m on 30/01/22
 * <p>
 * Problem: https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5};
        int val = 1;
        int nonDuplicateLength = new RemoveElement().removeElement(nums, val);
        System.out.print("[ ");
        for (int i = 0; i < nonDuplicateLength - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.print(nums[nonDuplicateLength - 1] + " ]");
    }
}
