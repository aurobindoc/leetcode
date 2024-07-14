package fkswitch.array_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 4, 5, 3 };
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }
}
