package old.easy;

/**
 * Created by aurobindo.m on 19/01/22
 * <p>
 * Problem: https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0, org = x;
        while (x > 0) {
            int d = x % 10;
            res = res * 10 + d;
            if (res % 10 != d) return false;
            x = x / 10;
        }
        return res == org;
    }

    public static void main(String[] args) {
        int x = 1234321;
        System.out.println(new PalindromeNumber().isPalindrome(x));
    }
}
