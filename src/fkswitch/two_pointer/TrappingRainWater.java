package fkswitch.two_pointer;

/* Question
 * NeetCode: https://neetcode.io/problems/trapping-rain-water
 * LeetCode: https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {
    public int trap(int[] height) {

        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            result += Math.max(0, min - height[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };

        System.out.println(trappingRainWater.trap(height));
    }
}
