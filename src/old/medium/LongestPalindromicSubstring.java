package old.medium;

/**
 * Created by aurobindo.m on 17/01/22
 *
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int res = 0;
        int low = 0, high = 1;
        for (int i = 0; i < s.length(); i++) {
            int l = i, h = i;
            while (l >= 0 && h < s.length()) {
                if (s.charAt(l) == s.charAt(h)) {
                    if (h - l + 1 > res) {
                        low = l;
                        high = h + 1;
                    }
                    l--;
                    h++;
                } else {
                    break;
                }
            }
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                l=i;
                h = i + 1;
                while (l >= 0 && h < s.length()) {
                    if (s.charAt(l) == s.charAt(h)) {
                        if (h - l + 1 > res) {
                            low = l;
                            high = h + 1;
                        }
                        l--;
                        h++;
                    } else {
                        break;
                    }
                }
            }
            res = Math.max(res, high - low);
        }
        return s.substring(low, high);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

}
