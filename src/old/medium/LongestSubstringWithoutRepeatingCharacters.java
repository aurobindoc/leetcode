package old.medium;

import java.util.HashMap;

/**
 * Created by aurobindo.m on 16/01/22
 * <p>
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int head = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                result = Math.max((i - head), result);
                head = Math.max(head, map.get(c)+1);
            }
            map.put(c, i);
        }
        return Math.max(((s.length()-head)), result);
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
