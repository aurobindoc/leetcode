package old.medium;

import utils.IntArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by aurobindo.m on 30/01/22
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int first = 0;
        boolean firstFlag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                first = i;
                firstFlag = true;
                break;
            }
        }
        if (firstFlag) {
            int ceiling = first + 1;
            for (int i = ceiling; i < nums.length; i++) {
                if (nums[i] > nums[first]) {
                    if (nums[i] < nums[ceiling]) {
                        ceiling = i;
                    }
                }
            }
            IntArrayUtils.swapList(nums, first, ceiling);
            Arrays.sort(nums, first+1, nums.length);
        } else {
            Arrays.sort(nums, 0, nums.length);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        new NextPermutation().nextPermutation(nums);
        IntArrayUtils.printList(nums);
    }
}
