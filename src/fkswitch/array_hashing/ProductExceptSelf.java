package fkswitch.array_hashing;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[nums.length -1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    public int[] productExceptSelfZeroSpace(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int suffix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];

        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productExceptSelf.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
