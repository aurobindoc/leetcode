package fkswitch.two_pointer;

import utils.IntArrayUtils;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int b = 0;
        int e = numbers.length-1;
        int[] res = new int[2];
        while(b<e)  {
            if(numbers[b] + numbers[e] < target)    {
                b++;
                continue;
            }
            if(numbers[b] + numbers[e] > target)    {
                e--;
                continue;
            }
            res[0] = b+1;
            res[1] = e+1;
            return res;
        }
        return res;
    }

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] numbers = { 2,3,4 };
        int target = 6;
        IntArrayUtils.printList(twoSum.twoSum(numbers, target));
    }
}