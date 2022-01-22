package medium;

import java.util.HashMap;

/**
 * Created by aurobindo.m on 22/01/22
 * <p>
 * Problem: https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int v1 = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;
            int v2 = map.get(s.charAt(i));
            if (v1 > v2) {
                res += (v1 - v2);
                i++;
            } else res += v2;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInteger().romanToInt(s));
    }
}
