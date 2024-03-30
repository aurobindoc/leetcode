package old.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aurobindo.m on 23/01/22
 * <p>
 * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneLetterCombination {

    public static final HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
        put('2', Arrays.asList('a', 'b', 'c'));
        put('3', Arrays.asList('d', 'e', 'f'));
        put('4', Arrays.asList('g', 'h', 'i'));
        put('5', Arrays.asList('j', 'k', 'l'));
        put('6', Arrays.asList('m', 'n', 'o'));
        put('7', Arrays.asList('p', 'q', 'r', 's'));
        put('8', Arrays.asList('t', 'u', 'v'));
        put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }};

    public List<String> letterCombinations(String digits) {
        Queue<String> q = new LinkedList<>();
        Queue<String> q1 = new LinkedList<>();
        if (digits.equals("")) return new ArrayList<>(q);
        q.add("");
        String temp = "";
        int pos = 0;
        while (!q.isEmpty() && pos < digits.length()) {
            temp = q.poll();
            for (char c : map.get(digits.charAt(pos))) {
                q1.add(temp + c);
            }
            if (q.isEmpty()) {
                q = q1;
                q1 = new LinkedList<>();
                pos++;
            }
        }

        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new PhoneLetterCombination().letterCombinations(digits));
    }
}
