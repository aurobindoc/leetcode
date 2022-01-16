package hard;

/**
 * Created by aurobindo.m on 16/01/22
 * <p>
 * Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            res[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        if (i == nums1.length) {
            i = j;
            nums1 = nums2;
        }
        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }

        return k % 2 == 0 ? (res[k / 2 - 1] + res[k / 2]) / 2.0 : res[k / 2];


    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(num1, num2));
    }
}
