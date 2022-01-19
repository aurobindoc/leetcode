package medium;

/**
 * Created by aurobindo.m on 18/01/22
 *
 * Problem: https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0, d = 0;
        boolean flag = x < 0;
        x = flag ? -1 * x : x;
        while (x > 0) {
            d = x % 10;
            res = res * 10 + d;
            if (res % 10 != d) return 0;
            x = x / 10;
        }
        return flag ? -1 * res : res;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(new ReverseInteger().reverse(x));
    }

}
