package fkswitch.two_pointer;

public class ContainerWithWater {
    public int maxArea(int[] height) {
        int b = 0;
        int e = height.length - 1;
        int max = 0;
        while(b<e)  {
            int area = Math.min(height[b], height[e]) * (e-b);
            max = Math.max(max, area);
            if(height[b] < height[e]) {
                b++;
            } else {
                e--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithWater containerWithWater = new ContainerWithWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(containerWithWater.maxArea(height));
    }
}
