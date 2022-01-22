package medium;

/**
 * Created by aurobindo.m on 22/01/22
 * <p>
 * Problem: https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int l = 0;
        int h = height.length - 1;
        int maxArea = 0;
        int area;
        while (l < h) {
            area = Math.min(height[l], height[h]) * (h - l);
            if (height[l] < height[h]) l++;
            else h--;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 3, 2, 5, 25, 24, 5};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
