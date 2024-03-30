package old.medium;

import java.util.*;

/**
 * Created by aurobindo.m on 24/01/22
 * <p>
 * Problem: https://leetcode.com/problems/4sum/
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSum(res, nums, i + 1, nums.length - 1, target - nums[i], nums[i]);
            }
        }
        return res;
    }

    private void threeSum(List<List<Integer>> res, int[] nums, int l, int r, int target, int w) {
        for (int i = l; i < r; i++) {
            if (i == l || nums[i] != nums[i - 1]) {
                twoSum(res, nums, i + 1, nums.length - 1, target - nums[i], w, nums[i]);
            }
        }
    }

    private void twoSum(List<List<Integer>> res, int[] nums, int l, int r, int target, int w, int x) {
        int v;
        while (l < r) {
            v = nums[l] + nums[r];
            if (v == target) {
                res.add(Arrays.asList(w, x, nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            } else if (v < target) {
                l++;
            } else r--;
        }
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "<" + a + ", " + b + ">";

        }
    }

    public List<List<Integer>> fourSumTimeLimitExceeded(int[] nums, int target) {
        HashSet<ArrayList<Integer>> sol = new HashSet<>();
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        int key;
        ArrayList<Pair> temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                key = nums[i] + nums[j];
                if (!map.containsKey(key)) {
                    temp = new ArrayList<>();
                    temp.add(new Pair(i, j));
                    map.put(key, temp);
                } else {
                    temp = map.get(key);
                    temp.add(new Pair(i, j));
                    map.put(key, temp);
                }
            }
        }
        ArrayList<Integer> tempInt;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                key = target - nums[i] - nums[j];
                if (map.containsKey(key)) {
                    for (Pair index : map.get(key)) {
                        if (i != index.a && i != index.b && j != index.a && j != index.b) {
                            tempInt = new ArrayList<>();
                            tempInt.add(nums[index.a]);
                            tempInt.add(nums[index.b]);
                            tempInt.add(nums[i]);
                            tempInt.add(nums[j]);
                            Collections.sort(tempInt);
                            sol.add(tempInt);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(sol);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        int[] nums = new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
//        int[] nums = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90};
        int target = 8;
        System.out.println(new FourSum().fourSum(nums, target));
    }
}
