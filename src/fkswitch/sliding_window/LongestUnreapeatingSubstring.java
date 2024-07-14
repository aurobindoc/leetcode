package fkswitch.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestUnreapeatingSubstring {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> visited = new HashSet<>();
        int l = 0, r = 0;
        int max = 0;

        while (r < s.length()) {
            if (visited.contains(s.charAt(r))) {
                visited.remove(s.charAt(l));
                l++;
            } else {
                visited.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        LongestUnreapeatingSubstring longestUnreapeatingSubstring = new LongestUnreapeatingSubstring();
        System.out.println(longestUnreapeatingSubstring.lengthOfLongestSubstring("aab"));
    }
}
