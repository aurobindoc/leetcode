package old.medium;


/**
 * Created by aurobindo.m on 30/01/22
 * <p>
 * Problem: https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int x, res = 0;
        while (a - b >= 0) {
            x = 0;
            while (a - (b << 1 << x) >= 0) x++;
            res += 1 << x;
            a -= b << x;
        }
        return dividend < 0 ? divisor < 0 ? res : -res : divisor < 0 ? -res : res;
    }

    public static void main(String[] args) {
        int dividend = 1025, divisor = 3;
        System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
